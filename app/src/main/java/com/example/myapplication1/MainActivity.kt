package com.example.myapplication1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.dataclass.LoanData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    //imp notes :  for click event and all the update changes in recyclerview alwas use its adapoter for changes no need to chane in activity
    // use @={"text"} for data binding from bothside and use @{"text"} for data binding from single side


    //  private val TAG = MainActivity::class.java.simpleName
    private val TAG = MainActivity::class.java
    lateinit var binding: ActivityMainBinding
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    //  private val dobPattern = "[0-9]{2}+/[0-9]{2}+/[0-9]{4}+"
    var MobilePattern = "[0-9]{10}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //data binding
        val loanDAtaObj = LoanData("Sumed", "1234567890", "sumedchaus@gmail.com", "habsiguda", "100000", "1", "1")
        binding.loanData = loanDAtaObj
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        calender_btn.setOnClickListener {

            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    editTextDateofBirth.setText("" + dayOfMonth + "/" + month + "/" + year)
                },
                year,
                month,
                day
            )
            dpd.show()

        }


// validation for app
        submit_Btn.setOnClickListener {
            var editTextCustomerName = editTextCustomerName.text.toString()
            var editTextMobileNumber = editTextMobileNumber.text.toString()
            var editTextEmailId = editTextEmailId.text.toString()
            var editTextAddress = editTextAddress.text.toString()
            var editTextLoanAmount = editTextLoanAmount.text.toString()
            var editTextLoanTenureAmount = editTextLoanTenureAmount.text.toString()
            var editTextRateOfInterest = editTextRateOfInterest.text.toString()


            if (editTextCustomerName == "") {
                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (radioGroupMarried_Single.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please Select Marital Status ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!editTextMobileNumber.matches(MobilePattern.toRegex())) {
                Toast.makeText(this, "Please Enter Valid Mobile Number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!editTextEmailId.matches(emailPattern.toRegex())) {
                Toast.makeText(this, "Please Enter Valid Email Address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (editTextAddress == "") {
                Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (editTextLoanAmount == "") {
                Toast.makeText(this, "Please Enter Loan Amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (editTextLoanTenureAmount == "") {
                Toast.makeText(this, "Please Enter Loan Tenure Month", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (editTextRateOfInterest == "") {
                Toast.makeText(this, "Please Enter The Rate of Interest", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            if (!checkBoxNEFTFacility.isChecked) {
                Toast.makeText(this, "Please Select the CheckBox ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            Log.d("TAG", "MainActivity:: LoanData $loanDAtaObj")//calender view

            val intent = Intent(this, BridgeActivity::class.java)
            startActivity(intent)

            }



    }

}
