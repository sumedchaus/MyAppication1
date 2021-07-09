package com.example.myapplication1

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.ApiClient
import com.example.myapplication1.adapter.DataAdpter
import com.example.myapplication1.dataclass.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRetrofitData: AppCompatActivity() {
    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerviewexample)
        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter= DataAdpter(dataList,this)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()
     //   pushPost()
    }

    private fun getData() {   //  used for on responce and failure method
        val call: Call<List<DataModel>> = ApiClient.api.getPhotos()  // calling the url using apibuilder and api interfaace and api call function(getPhotos)
        call.enqueue(object : Callback<List<DataModel>> {  // then call callback enque method

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }

        })
    }

//    private fun pushPost() {   //  used for on responce and failure method
//
//        val call = ApiClient.api.pushPost(Post(1, 2, "hj", "gyh"))
//
//        call.enqueue(object : Callback<Post> {  // then call callback enque method
//
//
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                progerssProgressDialog.dismiss()
//                Log.d("SecondActivity" , response.body()!!.title)
//
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                progerssProgressDialog.dismiss()
//                Toast.makeText(this@SecondActivity, "Operation Fail", Toast.LENGTH_SHORT).show()
//            }
//
//        })
//
//    }
}
