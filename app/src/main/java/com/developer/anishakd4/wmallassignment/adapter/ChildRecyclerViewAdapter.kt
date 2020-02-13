package com.developer.anishakd4.wmallassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.wmallassignment.databinding.HorizontalListBinding
import com.developer.anishakd4.wmallassignment.databinding.ListItemBinding
import com.developer.anishakd4.wmallassignment.model.ResturantModel

class ChildRecyclerViewAdapter : ListAdapter<ResturantModel, ChildRecyclerViewAdapter.ViewHolder>(DiffCallBack){

    companion object DiffCallBack : DiffUtil.ItemCallback<ResturantModel>() {
        override fun areItemsTheSame(oldItem: ResturantModel, newItem: ResturantModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ResturantModel, newItem: ResturantModel): Boolean {
            return oldItem.name.equals(newItem.name)
        }
    }

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(resturantModel: ResturantModel){
            binding.item = resturantModel
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ListItemBinding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}