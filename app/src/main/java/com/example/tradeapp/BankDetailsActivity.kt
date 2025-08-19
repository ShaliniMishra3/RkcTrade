package com.example.tradeapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BankDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bank_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinnerBank: Spinner = findViewById(R.id.spinnerBank)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item).apply {
            add("Select")
            add("HDFC Bank")
            add("ICICI Bank")
            add("SBI")
            add("Axis Bank")
            add("PNB")
            add("Indian Bank")
            add("Induslnd Bank")
            add("Bank Of India")
            add("Canara Bank")
            add("UCO Bank")
            add("Central Bank Of India")
            add("Kotak Mahindra Bank")
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBank.adapter = adapter
         val bankDetail=findViewById<Button>(R.id.btnBankDetail)
        bankDetail.backgroundTintList=null
        findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}