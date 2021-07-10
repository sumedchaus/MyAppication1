package com.example.myapplication1.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ItemlistloandataBinding
import com.example.myapplication1.dataclass.ListData
import kotlin.collections.ArrayList


class ListDataAdapter(var context: Context, var list: ArrayList<ListData>) :
    RecyclerView.Adapter<ListDataAdapter.ViewHolder>() {


    // Inflating Layout and ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemlistloandataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.itemlistloandata,
            parent,
            false
        )

        val viewholder = ViewHolder(binding)
        binding.showBtnTapbtn.setOnClickListener {


//            val model = list.get(viewholder.adapterPosition)  // used for getting the adapter position
            // below 3 lines for toast msg
//            val customDialog = AlertDialog.Builder(context)   // used for dialog creation
//
//                .setMessage(model.code)  // used for setting the msg
//                .show()   // used for msg show
            val dialogView =  LayoutInflater.from(context).inflate(R.layout.codename_custom_dialog, null)  //for layout and use contex for calling the view
            val customDialog = AlertDialog.Builder(context)         // used for dialog creation
                .setView(dialogView)      // used for set view
                .show()
            val btDismiss = dialogView.findViewById<Button>(R.id.btDismissCustomDialog)  // used for dismiss the dialog
            btDismiss.setOnClickListener {
                customDialog.dismiss()
            }
        }
        return viewholder
    }

    override fun getItemCount(): Int = list.size

    // Bind data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(list.get(position))
        val model = list.get(position)
        holder.binding.listData = model
    // dont need to set the dATA binding  in view holder need to chage in only bindviewholder



    }

    // Creating ViewHolder


    class ViewHolder(val binding: ItemlistloandataBinding) : RecyclerView.ViewHolder(binding.root) {



    }
    }


