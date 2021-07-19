package com.example.myapplication1.retrofitclient

import com.example.myapplication1.dataclass.personaldata.UploadResponseImage
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @Multipart
//    @POST("Api.php?apicall=upload")
    @POST("api/")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UploadResponseImage>



    companion object {
        operator fun invoke(): MyApi{

            return Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
//                .baseUrl("http://192.168.1.112/ImageUploader/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

    }
}

