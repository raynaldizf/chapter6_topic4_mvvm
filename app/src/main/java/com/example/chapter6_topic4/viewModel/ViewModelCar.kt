package com.example.chapter6_topic4.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter6_topic4.network.ApiClient
import com.example.chapter6_topic4.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar: ViewModel() {

    lateinit var liveDataCar: MutableLiveData<List<ResponseDataCarItem>?>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getliveDataCar(): MutableLiveData<List<ResponseDataCarItem>?> {
        return liveDataCar
    }

    fun callApiCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    }else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}