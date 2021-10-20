package com.developer.anishakd4.wmallassignment.adapter

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.wmallassignment.R
import com.developer.anishakd4.wmallassignment.databinding.PagerItemBinding
import com.developer.anishakd4.wmallassignment.databinding.ViewpagerListBinding
import com.developer.anishakd4.wmallassignment.model.ResturantModel

class ViewPagerAdapter(val list: List<ResturantModel>?, val metrics: DisplayMetrics?) : RecyclerView.Adapter<ViewPagerAdapter.PagerVH>() {

    class PagerVH(val binding: PagerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResturantModel) {
            binding.item = item
        }

        companion object {
            fun from(parent: ViewGroup): PagerVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: PagerItemBinding = PagerItemBinding.inflate(layoutInflater, parent, false)
                return PagerVH(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return PagerVH.from(parent)
    }

    override fun getItemCount(): Int {
        if (list != null) {
            return list!!.size
        }
        return 0;
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        if (list != null) {
            holder.bind(list!!.get(position))
//            val height = holder.binding.root.layoutParams.height
//            val width = holder.binding.root.layoutParams.width
//            holder.itemView.layoutParams = ViewGroup.LayoutParams(width - 20, height)
        }
    }

}