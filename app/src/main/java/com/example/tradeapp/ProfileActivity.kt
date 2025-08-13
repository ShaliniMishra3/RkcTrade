package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        findViewById<LinearLayout>(R.id.nav_watchlist).setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))

        }
        findViewById<LinearLayout>(R.id.nav_orders).setOnClickListener{
            startActivity(Intent(this,OrderActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.nav_portfolio).setOnClickListener{
            startActivity(Intent(this,PortfolioActivity::class.java))
        }
      findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener{
          startActivity(Intent(this,ProfileActivity::class.java))
      }
    }
}