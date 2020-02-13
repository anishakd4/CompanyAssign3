package com.developer.anishakd4.wmallassignment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.wmallassignment.databinding.GridListBinding
import com.developer.anishakd4.wmallassignment.databinding.HorizontalCardBinding
import com.developer.anishakd4.wmallassignment.databinding.HorizontalListBinding
import com.developer.anishakd4.wmallassignment.model.CustomData
import com.developer.anishakd4.wmallassignment.model.ResturantModel

private const val ITEM_TYPE_HLIST = 0
private const val ITEM_TYPE_GRID = 1
private const val ITEM_TYPE_HCARD = 2

class MainRecyclerViewAdapter : ListAdapter<CustomData, RecyclerView.ViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<CustomData>() {
        override fun areItemsTheSame(oldItem: CustomData, newItem: CustomData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CustomData, newItem: CustomData): Boolean {
            return oldItem.categoryName.equals(newItem.categoryName)
        }
    }

    class HorizontalListViewHolder(val binding: HorizontalListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customData: CustomData) {
            binding.item = customData
            binding.childRecycler.adapter = ChildRecyclerViewAdapter()
        }

        companion object {
            fun from(parent: ViewGroup): HorizontalListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: HorizontalListBinding = HorizontalListBinding.inflate(layoutInflater, parent, false)
                return HorizontalListViewHolder(binding)
            }
        }
    }

    class GridListViewHolder(val binding: GridListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customData: CustomData) {
            binding.item = customData
            binding.childRecycler.adapter = GridRecyclerviewAdapter(listOf<ResturantModel>())
        }

        companion object {
            fun from(parent: ViewGroup): GridListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: GridListBinding = GridListBinding.inflate(layoutInflater, parent, false)
                return GridListViewHolder(binding)
            }
        }
    }

    class HorizontalCardViewHolder(binding: HorizontalCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customData: CustomData) {

        }

        companion object {
            fun from(parent: ViewGroup): HorizontalCardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: HorizontalCardBinding = HorizontalCardBinding.inflate(layoutInflater, parent, false)
                return HorizontalCardViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).widgetType) {
            "H_LIST" -> ITEM_TYPE_HLIST
            "GRID" -> ITEM_TYPE_GRID
            "H_CARD" -> ITEM_TYPE_HCARD
            else -> ITEM_TYPE_HLIST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_HLIST -> HorizontalListViewHolder.from(parent)
            ITEM_TYPE_GRID -> GridListViewHolder.from(parent)
            ITEM_TYPE_HCARD -> HorizontalListViewHolder.from(parent)
            else -> HorizontalListViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i("anisham", "anisham MainRecyclerViewAdapter $position")
        val item = getItem(position)
        when (holder) {
            is HorizontalListViewHolder -> {
                holder.bind(item)
            }
            is GridListViewHolder -> {
                holder.bind(item)
            }
            is HorizontalCardViewHolder -> {
                holder.bind(item)
            }
        }
    }
}