package com.example.myapplication1

import android.app.DownloadManager
import android.app.ProgressDialog
import android.content.Context
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.myapplication1.retrofitclient.RetrofitClient
import kotlinx.android.synthetic.main.download_image.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class DownloadImage: AppCompatActivity() {
    lateinit var url : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.download_image)

        download_btnn.setOnClickListener {
            funDownloadImage()

        }
    }

    private fun funDownloadImage() {
        @Suppress("DEPRECATION")
        val progressDialog = ProgressDialog(this@DownloadImage)
        progressDialog.setTitle("Image is downloading, please wait")
        progressDialog.show()

        val call: Call<ResponseBody> = RetrofitClient.getClient.downloadFileUsingUrl("yc3CbKN.jpg")
        call.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val bytes: ByteArray = response.body()!!.bytes()
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                img_display_image.setImageBitmap(bitmap)
                progressDialog.dismiss()
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                progressDialog.dismiss()
            }
        })
    }
}