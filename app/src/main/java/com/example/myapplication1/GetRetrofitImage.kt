package com.example.myapplication1

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.ApiClient
import com.example.myapplication1.adapter.DataAdpter
import com.example.myapplication1.adapter.GetImageDataAdapter
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.ListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRetrofitImage: AppCompatActivity() {
    var imageList = ArrayList<GetImageData>()
    lateinit var progerssProgressDialog: ProgressDialog
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_image_data_recyclerview)
        recyclerView = findViewById(R.id.getImageDataRecycle)
        recyclerView.adapter = GetImageDataAdapter(imageList, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getImageData()
        //   pushPost()
    }

    private fun getImageData() {   //  used for on responce and failure method
        val call: Call<List<GetImageData>> =
            ApiClient.api.getImage()  // calling the url using apibuilder and api interfaace and api call function(getPhotos)
        call.enqueue(object : Callback<List<GetImageData>> {  // then call callback enque method


            override fun onResponse(call: Call<List<GetImageData>>, response: Response<List<GetImageData>>) {
                progerssProgressDialog.dismiss()
                imageList.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<GetImageData>>, t: Throwable) {
                progerssProgressDialog.dismiss()
            }

        })
    }
}