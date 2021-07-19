package com.example.myapplication1.retrofitclient

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface DataService {

    @GET
    fun downloadFileUsingUrl(@Url fileUrl: String): Call<ResponseBody>
}