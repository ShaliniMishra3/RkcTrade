package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoneyTransfer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_money_transfer)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val icCloseMoney=findViewById<ImageView>(R.id.ic_closeMoney)
        icCloseMoney.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val spinnerBeneficiary=findViewById<Spinner>(R.id.spinnerBeneficiary)
        val spinnerBeneficiaryData=listOf(
            "Select Beneficiary"
        )
        val adapterBeneficiary= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerBeneficiaryData)
        spinnerBeneficiary.adapter=adapterBeneficiary

        val spinnerTransfer=findViewById<Spinner>(R.id.spinnerTransfer)
        val spinnerTransferData=listOf(
            "Select Transfer"
        )
        val adapterTransfer= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerTransferData)
        spinnerTransfer.adapter=adapterTransfer
    }
}