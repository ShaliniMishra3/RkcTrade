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

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val signUpTextView = findViewById<TextView>(R.id.signUpTextView)
        signUpTextView.text = Html.fromHtml("Don't have account? <font color='#3F51B5'><b>Sign In</b></font>", Html.FROM_HTML_MODE_LEGACY)
        signUpTextView.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginBtn=findViewById<Button>(R.id.loginButton)
        loginBtn.backgroundTintList = null
        loginBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        val forgetPassword=findViewById<TextView>(R.id.ForgetPassword)
        forgetPassword.setOnClickListener {
            startActivity(Intent(this,ForgetPasswordActivity::class.java))

        }

    }
}