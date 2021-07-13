package com.example.myapplication1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.dataclass.personaldata.UploadResponseImage
import com.example.myapplication1.retrofitclient.MyApi
import kotlinx.android.synthetic.main.upload_image.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Multipart
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class ImageUpload :AppCompatActivity(),UploadRequestBody.UploadCallback {

    private var selectedImage: Uri? = null

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_image)


        image_View.setOnClickListener{
            oprmImageChooser()
        }
        button_upload.setOnClickListener {
            uploadImage()
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun uploadImage(){
        if (selectedImage== null){
            layout_root.snackbar("Slect An Image First")
            return
        }

        val parcelFileDescriptor = contentResolver.openAssetFileDescriptor(selectedImage!!, "r", null) ?: return
        val file = File(cacheDir, contentResolver.getFileName(selectedImage!!))
        val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        val outputStream = FileOutputStream(file)
        inputStream.copyTo(outputStream)

        progress_Bar.progress = 0
        val body = UploadRequestBody(file, "image", this)

        MyApi().uploadImage(
            MultipartBody.Part.createFormData("Image", file.name, body),
            RequestBody.create(MediaType.parse("multipart/form-data"), "Image from my Device")
        ).enqueue(object: Callback<UploadResponseImage> {

            override fun onResponse(call: Call<UploadResponseImage>, response: Response<UploadResponseImage>) {
               progress_Bar.progress= 100
                layout_root.snackbar(response.body()?.message.toString())
            }

            override fun onFailure(call: Call<UploadResponseImage>, t: Throwable) {

                layout_root.snackbar(t.message!!)
            }

        })
    }

    fun oprmImageChooser(){

        Intent(Intent.ACTION_PICK).also {
            it.type = "image/*"
            val mimeTypes = arrayOf("image/jpeg", "image/pmg")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startActivityForResult(it, REQUEST_CODE_IMAGE_PICKER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                REQUEST_CODE_IMAGE_PICKER -> {
                    selectedImage = data?.data
                    image_View.setImageURI(selectedImage)

                }
            }
        }
    }

    companion object{
        private const val  REQUEST_CODE_IMAGE_PICKER = 100
    }

    override fun onProgressUpdate(percentage: Int) {
        progress_Bar.progress = percentage
    }
}