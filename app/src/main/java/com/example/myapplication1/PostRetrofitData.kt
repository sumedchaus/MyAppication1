package com.example.myapplication1

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication1.adapter.ApiClient
import com.example.myapplication1.databinding.PostretrofitdataBinding
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bridge.*
import kotlinx.android.synthetic.main.postretrofitdata.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRetrofitData() : AppCompatActivity() {
    lateinit var binding: PostretrofitdataBinding
    lateinit var progerssProgressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.postretrofitdata)


        val postDataObj = Post(null,null,null,null )
        binding.postData = postDataObj

        postDataBtn.setOnClickListener {
//
//            var userIdEditText = userIdEditText.text.toString()
//            var titleEditText = titleEditText.text.toString()
//            var bodyEditText = bodyEditText.text.toString()



            if (postDataObj.userId == "") {
                Toast.makeText(this, "Please Enter UserID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (postDataObj.title == "") {
                Toast.makeText(this, "Please Enter Title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (postDataObj.body == "") {
                Toast.makeText(this, "Please Enter body", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val modal = Post(postDataObj.userId, "1",postDataObj.title,postDataObj.body)
            val call = ApiClient.api.pushPost(modal)
            // or
        //    val call = ApiClient.api.pushPost(Post(userIdEditText, "1", titleEditText, bodyEditText))


            call.enqueue(object : Callback<Post> {  // then call callback enque method


                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Log.d("PostRetrofitData", response.body().toString())
                    //    Log.d("PostRetrofitData" , response.body()!!.title) // or use this  for only single variable
                    Toast.makeText(this@PostRetrofitData, "$response", Toast.LENGTH_SHORT).show()


                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Toast.makeText(this@PostRetrofitData, "Operation Fail", Toast.LENGTH_SHORT).show()
                }

            })
            pushPost()
            pushPost1()
        }


    }

    // used for textview post data

    private fun pushPost() {   //  used for on responce and failure method
        // val response: Response<Post> = ApiClient.api.pushPost(Post(1,2,"fgh","fhg"))
        val call = ApiClient.api.pushPost(Post("7", "6", "Sumed", "abcb"))

        call.enqueue(object : Callback<Post> {  // then call callback enque method


            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("PostRetrofitData", response.body().toString())
                //    Log.d("SecondActivity" , response.body()!!.title) // or use this

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@PostRetrofitData, "Operation Fail", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun pushPost1() {   //  used for on responce and failure method
        // val response: Response<Post> = ApiClient.api.pushPost(Post(1,2,"fgh","fhg"))
        val call = ApiClient.api.pushPost1(Post("77", "65", "chaus", "deff"))

        call.enqueue(object : Callback<Post> {  // then call callback enque method


            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("PostRetrofitData", response.body().toString())
                Toast.makeText(this@PostRetrofitData, "$response", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@PostRetrofitData, "Operation Fail", Toast.LENGTH_SHORT).show()
            }

        })

    }


}


