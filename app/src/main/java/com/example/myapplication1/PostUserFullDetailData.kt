package com.example.myapplication1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication1.retrofitclient.ApiClient
import com.example.myapplication1.databinding.UserFullDetailBinding
import com.example.myapplication1.dataclass.personaldata.*
import kotlinx.android.synthetic.main.user_full_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostUserFullDetailData: AppCompatActivity() {
     lateinit var binding : UserFullDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.user_full_detail)

        var userDataObj = PersonalData(User("","","",""),
        Company("","",""),
        Geo("",""),
       "","", Address("","","","")
        )

        binding.personalData = userDataObj


        Btn_Personal_Info_Submit.setOnClickListener {

            if (userDataObj.user.name == ""){
                Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


                val call = ApiClient.api.postUser(userDataObj)

                call.enqueue(object : Callback<PersonalData> {  // then call callback enque method


                    override fun onResponse(call: Call<PersonalData>, response: Response<PersonalData>) {
                        Log.d("UserFullDetailData::", response.body().toString())
                        Toast.makeText(this@PostUserFullDetailData, "$response", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<PersonalData>, t: Throwable) {
                        Toast.makeText(this@PostUserFullDetailData, "Operation Fail", Toast.LENGTH_SHORT).show()
                    }

                })

            }
        }

    }




