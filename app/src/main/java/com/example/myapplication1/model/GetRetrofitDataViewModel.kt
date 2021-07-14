package com.example.myapplication1.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.dataclass.DataModel
import com.example.myapplication1.retrofitclient.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRetrofitDataViewModel :ViewModel() {

    lateinit var getLiveData: MutableLiveData<List<DataModel>>  // 1st step create mutable live data
    init {
        getLiveData = MutableLiveData()  //2 then initialized it
    }

    fun getUser():MutableLiveData<List<DataModel>>  {  //create fun  and make its subclass of mutable livedata(data class)

        return getLiveData
    }

        fun makeApiCall(){      // 4 write call api code in view model and u cant use log toast like fun here
             // call the

    //
    //        var listview = arrayListOf<DataModel>(DataModel(0, 1, "sumed","asdd","dfgg"))
    //        getLiveData.postValue(listview)


            val call: Call<List<DataModel>> = ApiClient.api.getPhotos()  // calling the url using apibuilder and api interfaace and api call function(getPhotos)
            call.enqueue(object : Callback<List<DataModel>> {

                override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                    if (response!!.isSuccessful){
                    getLiveData.postValue(response.body()!!)
                }

            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                getLiveData.postValue(null)
            }
        })


     // then call callback enque method


    }


}