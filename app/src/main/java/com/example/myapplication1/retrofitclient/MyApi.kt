package com.example.myapplication1.retrofitclient

import com.example.myapplication1.dataclass.personaldata.UploadResponseImage
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface MyApi {

    @Multipart
    @POST("Api.php?apicall=upload")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UploadResponseImage>

    companion object {
        operator fun invoke(): MyApi{

            return Retrofit.Builder()
                .baseUrl("http://192.168.1.112/ImageUploader/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

    }
}

