package com.example.myapplication1.adapter

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL:String="https://jsonplaceholder.typicode.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}

//    val getClient: ApiInterface  // second method for ApiBuilder
//        get() {
//
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)   /// main url -> then
//                .client(client)        // client url (client url is =  photos)
//                .addConverterFactory(GsonConverterFactory.create(gson))   // then json converts it
//                .build()             // then build//  final url became -> jsonplaceholder.typicode.com/photos
//            return retrofit.create(ApiInterface::class.java)  //after PI CLIENT IT GOES TO next  activiti
//
//        }
