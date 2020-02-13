package com.developer.anishakd4.wmallassignment.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.anishakd4.wmallassignment.model.CategoryModel
import com.developer.anishakd4.wmallassignment.model.CustomData
import com.developer.anishakd4.wmallassignment.networking.ResturantApi
import kotlinx.coroutines.*


class OverviewFragementViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val num = arrayOf<String>("H_LIST", "GRID", "H_CARD")

    var categories = ArrayList<CategoryModel>()

    private var _listItems = MutableLiveData<ArrayList<CustomData>>()
    val listitems: LiveData<ArrayList<CustomData>>
        get() = _listItems

    init {
        getProperties()
    }

    private fun getProperties() {
        coroutineScope.launch {
            val getPropertiesDeferred = ResturantApi.getDataInterface.getCategories()
            try {
                val listResult = getPropertiesDeferred.await()
                for (category in listResult.categories) {
                    categories.add(category.categories)
                }
                Log.i("anisham", "anisham category size= ${categories.size}")
                for (category in categories) {
                    async { getResturants(category) }
                }
            } catch (t: Throwable) {
                Log.i("anisham", "anisham = fail ${t.localizedMessage}")
            }

        }
    }

    private suspend fun getResturants(category: CategoryModel) {
        val response = ResturantApi.getDataInterface.getResturants(category.id)
        val resturantlist = response.await()
        if (_listItems.value == null) {
            _listItems.value = ArrayList<CustomData>()
        }
        val newArray = _listItems.value
        val list = resturantlist.restaurants.map { it.restaurant }
        if(list.size > 0){
            if (_listItems.value!!.size > 0) {
                _listItems.value!!.add(CustomData(category.name, num.get(_listItems.value!!.size % num.size), list))
            } else {
                _listItems.value!!.add(CustomData(category.name, num.get(0), list))
            }
        }

        _listItems.value = newArray
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}