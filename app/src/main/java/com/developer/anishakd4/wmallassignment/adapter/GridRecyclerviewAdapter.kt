package com.developer.anishakd4.wmallassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.wmallassignment.databinding.GridItemBinding
import com.developer.anishakd4.wmallassignment.databinding.HorizontalListBinding
import com.developer.anishakd4.wmallassignment.model.CustomData
import com.developer.anishakd4.wmallassignment.model.ResturantModel

class GridRecyclerviewAdapter(var list: List<ResturantModel>?) : RecyclerView.Adapter<GridRecyclerviewAdapter.ViewHolder>() {

    class ViewHolder(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(resturantModel: ResturantModel) {
            binding.item = resturantModel
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: GridItemBinding = GridItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        if(list != null){
            if(list!!.size > 4){
                return 4
            }else{
                return list!!.size
            }
        }
        return 0;
    }

    fun updateList(list: List<ResturantModel>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list != null){
            holder.bind(list!!.get(position))
        }

    }

//    companion object DiffCallBack : DiffUtil.ItemCallback<ResturantModel>() {
//        override fun areItemsTheSame(oldItem: ResturantModel, newItem: ResturantModel): Boolean {
//            return oldItem === newItem
//        }
//
//        override fun areContentsTheSame(oldItem: ResturantModel, newItem: ResturantModel): Boolean {
//            return oldItem.name.equals(newItem.name)
//        }
//    }


//    class ViewHolder(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(resturantModel: ResturantModel) {
//            binding.item = resturantModel
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): ViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding: GridItemBinding = GridItemBinding.inflate(layoutInflater, parent, false)
//                return ViewHolder(binding)
//            }
//        }
//    }

//    override fun getItemCount(): Int {
//        return super.getItemCount()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
}