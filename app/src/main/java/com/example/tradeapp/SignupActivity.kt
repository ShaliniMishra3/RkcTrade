package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signUpTextView1= findViewById<TextView>(R.id.signUpTextView1)
        signUpTextView1.text = Html.fromHtml("Don't have account? <font color='#3F51B5'><b>Sign Up</b></font>", Html.FROM_HTML_MODE_LEGACY)
        signUpTextView1.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        val signupBtn=findViewById<Button>(R.id.loginBtn)
        signupBtn.backgroundTintList=null

    }
}