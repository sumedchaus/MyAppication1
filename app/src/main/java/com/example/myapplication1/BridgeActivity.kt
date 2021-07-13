package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bridge.*

class BridgeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bridge)

        loanBridgeBtn.setOnClickListener {
            val intent = Intent(this, ListLoanPage::class.java)
            startActivity(intent)
        }
        retrofitGetBtn.setOnClickListener {
            val intent = Intent(this, GetRetrofitData::class.java)
            startActivity(intent)
        }
        postRetrofitBtn.setOnClickListener {
            val intent = Intent(this, PostRetrofitData::class.java)
            startActivity(intent)
        }
        getImage.setOnClickListener {
            val intent = Intent(this, GetRetrofitImage::class.java)
            startActivity(intent)
        }
        get_personal_Info.setOnClickListener {
            val intent = Intent(this, PostUserFullDetailData::class.java)
            startActivity(intent)
        }
        tods_Data.setOnClickListener {
            val intent = Intent(this, GetTodsData::class.java)
            startActivity(intent)
        }
        uploadImageBridge.setOnClickListener {
            val intent = Intent(this, ImageUpload::class.java)
            startActivity(intent)

        }
    }
}