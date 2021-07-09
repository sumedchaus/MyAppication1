package com.example.myapplication1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.DataAdpter
import com.example.myapplication1.adapter.GetImageDataAdapter
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.ListData

class GetRetrofitImage: AppCompatActivity() {
    var imageList = ArrayList<GetImageData>()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_image_data_recyclerview)
        recyclerView = findViewById(R.id.getImageDataRecycle)
        recyclerView.adapter = GetImageDataAdapter(imageList, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    fun imagedata(){
        fun namepage() {
            //crating an arraylist to store users using the data class user

            imageList.add(GetImageData(s"1", 1))
            myList.add(ListData("2", "sumed"))
            myList.add(ListData("3", "sumed"))
            myList.add(ListData("4", "sumed"))
            myList.add(ListData("5", "sumed"))
            myList.add(ListData("6", "sumed"))
            myList.add(ListData("7 ", "sumed"))
            myList.add(ListData("8", "sumed"))
            myList.add(ListData("9", "sumed"))
            myList.add(ListData("10", "sumed"))

        }