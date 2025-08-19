package com.example.tradeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LockActivity : AppCompatActivity() {
    private lateinit var session: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lock)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        session = SessionManager(this)

        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val enteredPassword = passwordInput.text.toString()
            if (enteredPassword == session.getPassword()) {
                session.setUnlocked(true)
                finish() // unlocks and returns to MainActivity
            } else {
                Toast.makeText(this, "Wrong password! Please try again.", Toast.LENGTH_SHORT).show()
                passwordInput.text.clear()
            }
        }

        // Disable back button
        this.setFinishOnTouchOutside(false)
    }

    override fun onBackPressed() {
        // Do nothing to prevent bypass
    }
    }
