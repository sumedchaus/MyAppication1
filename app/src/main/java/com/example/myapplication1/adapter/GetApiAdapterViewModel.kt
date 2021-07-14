package com.example.myapplication1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.dataclass.GetImageData
import com.example.myapplication1.dataclass.Tods


class GetApiAdapterViewModel(private var imageList: List<Tods>, private val context: Context) : RecyclerView.Adapter<GetApiAdapterViewModel.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.get_data_viewmodel, parent, false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel= imageList[position]


        holder.titleTextView.text=dataModel.title
        holder.idTextView.text=dataModel.albumId
        holder.idTextView.text=dataModel.url

    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView
        var idTextView : TextView
        var imageTextView : TextView
        init {
            titleTextView=itemLayoutView.findViewById(R.id.todstitleTextView)
            idTextView=itemLayoutView.findViewById(R.id.todsuseridTextView)
            imageTextView=itemLayoutView.findViewById(R.id.todsCompleteTExxtView)
        }

    }



}