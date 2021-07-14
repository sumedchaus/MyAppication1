package com.example.myapplication1.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.Post
import com.example.myapplication1.retrofitclient.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRetrofitDataViewModel : ViewModel() {

    lateinit var postLiveData: MutableLiveData<Post>

    init {
        postLiveData = MutableLiveData()  //2 then initialized it
    }

    fun postUser():MutableLiveData<Post> {  //create fun  and make its subclass of mutable livedata(data class)

        return postLiveData
    }
    fun postApiCall(){

        val modal = Post("","","","")
        val call = ApiClient.api.pushPost(modal)
        // or
        //    val call = ApiClient.api.pushPost(Post(userIdEditText, "1", titleEditText, bodyEditText))


        call.enqueue(object : Callback<Post> {  // then call callback enque method

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("PostRetrofitData", response.body().toString())
                //    Log.d("PostRetrofitData" , response.body()!!.title) // or use this  for only single variable
                postLiveData.postValue(response.body()!!)


            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                postLiveData.postValue(null)

            }

        })
    }

}