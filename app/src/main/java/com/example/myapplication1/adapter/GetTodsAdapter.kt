package com.example.myapplication1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.databinding.TodsDataBinding
import com.example.myapplication1.dataclass.Tods

class GetTodsAdapter{

//    (private var todsList: List<Tods>, private val context: Context) : RecyclerView.Adapter<GetTodsAdapter.ViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding: TodsDataBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(context),
//            R.layout.tods_data,
//            parent,
//            false
//        )
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return todsList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val dataModel= todsList[position]
//        holder.binding.todsList = dataModel
//
//        dataModel.userId
//        dataModel.tilte
//        dataModel.completed
//    }
//
//
//    class ViewHolder(val binding: TodsDataBinding) : RecyclerView.ViewHolder(binding.root) {
//
//
//    }

}