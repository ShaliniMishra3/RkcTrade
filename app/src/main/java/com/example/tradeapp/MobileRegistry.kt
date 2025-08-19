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

class MobileRegistry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mobile_registry)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val icCloseMobile=findViewById<ImageView>(R.id.ic_closeMobile)
        icCloseMobile.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val spinnerState=findViewById<Spinner>(R.id.spinnerState)
        val states=listOf(
            "Select State",
            "Uttar Pradesh",
            "Tamil Nadu",
            "Madhya Pradesh",
            "Uttar Pradesh",
            "Bihar",
            "Delhi",
            "Karnataka",
            "Andhra Pradesh",
            "UttarKhand",
            "Jammu Kashmir"
        )
        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,states)
        spinnerState.adapter=adapter
    }
}