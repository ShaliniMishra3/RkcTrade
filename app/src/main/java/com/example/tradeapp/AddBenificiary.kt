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

class AddBenificiary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_benificiary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val icCloseAdd=findViewById<ImageView>(R.id.ic_closeAddBenificiary)
        icCloseAdd.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val spinneBank=findViewById<Spinner>(R.id.spinnerBank)
        val bank=listOf(
            "Select Bank",
            "Panjab National Bank",
            "State Bank of India",
            "Bank of Badora",
            "HDFC Bank"
        )
        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,bank)
        spinneBank.adapter=adapter
    }
}