package com.developer.anishakd4.wmallassignment

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.developer.anishakd4.wmallassignment.adapter.ChildRecyclerViewAdapter
import com.developer.anishakd4.wmallassignment.adapter.GridRecyclerviewAdapter
import com.developer.anishakd4.wmallassignment.adapter.MainRecyclerViewAdapter
import com.developer.anishakd4.wmallassignment.model.CustomData
import com.developer.anishakd4.wmallassignment.model.ResturantModel

@BindingAdapter("listdata")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<CustomData>?){
    Log.i("anisham","anisham bindRecyclerView ${data?.size}")
    val adapter = recyclerView.adapter as MainRecyclerViewAdapter
    adapter.submitList(data?.toList())
}

@BindingAdapter("listdataHL")
fun bindRecyclerViewHL(recyclerView: RecyclerView, data: List<ResturantModel>?){
    Log.i("anisham","anisham bindRecyclerViewHL ${data?.size}")
    val adapter = recyclerView.adapter as ChildRecyclerViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("listdataGridList")
fun bindRecyclerViewGridList(recyclerView: RecyclerView, data: List<ResturantModel>?){
    Log.i("anisham","anisham bindRecyclerViewHL ${data?.size}")
    val adapter = recyclerView.adapter as GridRecyclerviewAdapter
    adapter.updateList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
            .into(imgView)

    }
}