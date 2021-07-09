package com.example.myapplication1.adapter

import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("photos")
fun getPhotos(): Call<List<DataModel>>

    @POST("posts")
     fun pushPost(
        @Body post: Post): Call<Post>

    @POST("posts")
    fun pushPost1(
        @Body post: Post): Call<DataModel>

    @GET("photos")
    fun getImage(): Call<List<GetImageData>>

    @GET("posts")
    fun getPost(): Call<List<Post>>
}
