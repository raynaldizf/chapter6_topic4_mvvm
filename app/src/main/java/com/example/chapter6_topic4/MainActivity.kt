package com.example.chapter6_topic4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6_topic4.viewModel.ViewModelCar
import com.example.chapter6_topic4.databinding.ActivityMainBinding
import com.example.chapter6_topic4.view.AdapterCar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var carAdapter: AdapterCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callApiCar()
        viewModel.getliveDataCar().observe(this, Observer {
            carAdapter = AdapterCar(it)
            if ( it != null){
                binding.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvList.adapter = AdapterCar(it)

            }
        })
    }
}