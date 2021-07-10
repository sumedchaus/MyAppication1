package com.example.myapplication1

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.ApiClient
import com.example.myapplication1.adapter.DataAdpter
import com.example.myapplication1.adapter.GetTodsAdapter
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.Tods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetTodsData:AppCompatActivity() {
//
//        lateinit var progerssProgressDialog: ProgressDialog
//        var todsList = ArrayList<Tods>()
//
//        lateinit var recyclerView: RecyclerView
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.recyclerview_tods_data)
//            recyclerView = findViewById(R.id.tods_recyclerView)
//
//            //setting up the adapter
//            recyclerView.adapter= GetTodsAdapter(todsList,this)
//            recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//
//            progerssProgressDialog= ProgressDialog(this)
//            progerssProgressDialog.setTitle("Loading")
//            progerssProgressDialog.setCancelable(false)
//            progerssProgressDialog.show()
//            getTodsData()
//        }
//
//        private fun getTodsData() {   //  used for on responce and failure method
//            val call: Call<List<Tods>> = ApiClient.api.getTods()  // calling the url using apibuilder and api interfaace and api call function(getPhotos)
//            call.enqueue(object : Callback<List<Tods>> {  // then call callback enque method
//
//                override fun onResponse(call: Call<List<Tods>>?, response: Response<List<Tods>>?) {
//                    progerssProgressDialog.dismiss()
//                    todsList.addAll(response!!.body()!!)
//                    recyclerView.adapter!!.notifyDataSetChanged()
//                }
//
//                override fun onFailure(call: Call<List<Tods>>?, t: Throwable?) {
//                    progerssProgressDialog.dismiss()
//                }
//
//            })
//        }

    }
