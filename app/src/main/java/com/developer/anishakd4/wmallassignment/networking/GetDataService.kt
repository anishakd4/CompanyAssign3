package com.developer.anishakd4.wmallassignment.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val httpClient: OkHttpClient.Builder =
    OkHttpClient.Builder().addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original: Request = chain.request()
            val request =
                original.newBuilder().header("user-key", "c750173e8cf7e5fdc2c331cf897ee8c3")
                    .method(original.method(), original.body()).build()
            return chain.proceed(request)
        }

    })

var client = httpClient.build()

private const val BASE_URL = "https://developers.zomato.com";
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(client)
    .build()

object ResturantApi {
    val getDataInterface: GetDataInterface by lazy {
        retrofit.create(GetDataInterface::class.java)
    }
}