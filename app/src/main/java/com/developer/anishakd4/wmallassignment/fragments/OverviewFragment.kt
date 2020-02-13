package com.developer.anishakd4.wmallassignment.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.anishakd4.wmallassignment.adapter.MainRecyclerViewAdapter
import com.developer.anishakd4.wmallassignment.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment(){

    private val viewModel: OverviewFragementViewModel by lazy {
        ViewModelProvider(this).get(OverviewFragementViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.mainList.adapter = MainRecyclerViewAdapter(getDisplayMetrics())

        return binding.root
    }

    private fun getDisplayMetrics(): DisplayMetrics? {
        if(activity != null){
            val display = activity!!.windowManager.defaultDisplay
            val metrics = DisplayMetrics()
            display.getMetrics(metrics)

            return metrics
        }
        return null
    }
}