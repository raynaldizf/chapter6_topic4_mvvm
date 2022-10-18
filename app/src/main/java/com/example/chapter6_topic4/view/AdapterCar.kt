package com.example.chapter6_topic4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter6_topic4.R
import com.example.chapter6_topic4.model.ResponseDataCarItem
import kotlinx.android.synthetic.main.item_cars.view.*

class AdapterCar(private var dataCar: List<ResponseDataCarItem>?): RecyclerView.Adapter<AdapterCar.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cars, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvTitle.text = dataCar!![position].name
        holder.itemView.tvPrice.text = dataCar!![position].price.toString()
    }

    override fun getItemCount(): Int {
        return dataCar!!.size
    }
}