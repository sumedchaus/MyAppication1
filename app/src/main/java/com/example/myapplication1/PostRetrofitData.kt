package com.example.myapplication1

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.adapter.ApiClient
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.Post
import kotlinx.android.synthetic.main.bridge.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRetrofitData() :AppCompatActivity() {
    lateinit var progerssProgressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postretrofitdata)


       pushPost()
        pushPost1()



    }
    private fun pushPost() {   //  used for on responce and failure method
        // val response: Response<Post> = ApiClient.api.pushPost(Post(1,2,"fgh","fhg"))
        val call = ApiClient.api.pushPost(Post(7, 6, "Sumed", "abcb"))

        call.enqueue(object : Callback<Post> {  // then call callback enque method


            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("PostRetrofitData" , response.body().toString())
            //    Log.d("SecondActivity" , response.body()!!.title) // or use this

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@PostRetrofitData, "Operation Fail", Toast.LENGTH_SHORT).show()
            }

        })

    }
    private fun pushPost1() {   //  used for on responce and failure method
        // val response: Response<Post> = ApiClient.api.pushPost(Post(1,2,"fgh","fhg"))
        val call = ApiClient.api.pushPost1(Post(77, 65, "chaus", "deff"))

        call.enqueue(object : Callback<DataModel> {  // then call callback enque method




            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                Log.d("PostRetrofitData" , response.body().toString())
                Toast.makeText(this@PostRetrofitData, "$response", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Toast.makeText(this@PostRetrofitData, "Operation Fail", Toast.LENGTH_SHORT).show()
            }

        })

    }


}


