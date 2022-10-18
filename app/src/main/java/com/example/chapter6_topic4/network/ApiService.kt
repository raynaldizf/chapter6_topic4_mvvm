package com.example.chapter6_topic4.network

import com.example.chapter6_topic4.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar(): Call<List<ResponseDataCarItem>>
}