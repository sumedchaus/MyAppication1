package com.example.myapplication1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.adapter.ListDataAdapter
import com.example.myapplication1.dataclass.ListData
import kotlinx.android.synthetic.main.recyclerviewloandata.*

class ListLoanPage : AppCompatActivity() {
    var myList = ArrayList<ListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerviewloandata)
        //getting recyclerview from xml
        val loanDataRecyclerView: RecyclerView = loanDataRecyclerView
        //adding a layoutmanager
        loanDataRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        //creating our adapter
        val adapter = ListDataAdapter(this, myList)
        //now adding the adapter to recyclerview
        loanDataRecyclerView.adapter = adapter
        namepage()



    }

    fun namepage() {
        //crating an arraylist to store users using the data class user

        myList.add(ListData("1", "sumed",R.drawable.ic_user))
        myList.add(ListData("2", "sumed",R.drawable.ic_user))
        myList.add(ListData("3", "sumed",R.drawable.ic_user))
        myList.add(ListData("4", "sumed",R.drawable.ic_user))
        myList.add(ListData("5", "sumed",R.drawable.ic_user))
        myList.add(ListData("6", "sumed",R.drawable.ic_user))
        myList.add(ListData("7", "sumed",R.drawable.ic_user))
        myList.add(ListData("8", "sumed",R.drawable.ic_user))
        myList.add(ListData("9", "sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))
        myList.add(ListData("10","sumed",R.drawable.ic_user))

    }

//    public fun showCustomAlert() {
//        val dialogView = layoutInflater.inflate(R.layout.codename_custom_dialog, null)
//        val customDialog = AlertDialog.Builder(this)
//            .setView(dialogView)
//            .show()
//        val btDismiss = dialogView.findViewById<Button>(R.id.btDismissCustomDialog)
//        btDismiss.setOnClickListener {
//            customDialog.dismiss()
//        }
//    }




}


/* private fun showCustomDialog() {
     val dialogBinding: CodenameCustomDialogBinding? = DataBindingUtil.inflate(
             LayoutInflater.from(this),
             R.layout.codename_custom_dialog,
             null,
             false
         )

     val customDialog = AlertDialog.Builder(this, 0).create()

     customDialog.apply {
         setView(dialogBinding?.root)
         setCancelable(false)
     }.show()

     dialogBinding?.btnOk?.setOnClickListener {
         customDialog.dismiss()
     }
 */

