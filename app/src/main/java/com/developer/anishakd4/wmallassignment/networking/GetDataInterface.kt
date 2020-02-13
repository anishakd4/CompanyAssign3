package com.developer.anishakd4.wmallassignment.networking

import com.developer.anishakd4.wmallassignment.model.MainCategoryModel
import com.developer.anishakd4.wmallassignment.model.MainModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataInterface {

    @GET("api/v2.1/categories")
    fun getCategories(): Deferred<MainCategoryModel>

    @GET("api/v2.1/search?entity_id=1&entity_type=city")
    fun getResturants(@Query("category") category: Int): Deferred<MainModel>
}