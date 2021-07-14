package com.example.myapplication1.retrofitclient

import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.Post
import com.example.myapplication1.dataclass.Tods
import com.example.myapplication1.dataclass.personaldata.PersonalData
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
        @Body post: Post): Call<Post>

    @GET("photos")
    fun getImage(): Call<List<GetImageData>>

    @GET("posts")
    fun getPost(): Call<List<Post>>

    @POST("users")
    fun postUser(
        @Body personalData: PersonalData): Call<PersonalData>

    @GET("photos")
    fun getTods(): Call<List<Tods>>



}
