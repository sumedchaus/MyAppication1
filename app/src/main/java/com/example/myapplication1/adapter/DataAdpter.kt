package com.example.myapplication1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.dataclass.DataModel

  class DataAdpter(private var dataList: ArrayList<DataModel>, private val context: Context) : RecyclerView.Adapter<DataAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.second_activity, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)

        holder.titleTextView.text=dataModel.url
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView:TextView
        init {
            titleTextView=itemLayoutView.findViewById(R.id.title)
        }

    }

}