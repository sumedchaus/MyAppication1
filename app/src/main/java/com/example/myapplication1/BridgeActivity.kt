package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bridge.*
import kotlinx.android.synthetic.main.get_image_data.*

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
            val intent = Intent(this, UserFullDetailData::class.java)
            startActivity(intent)
        }

    }
}