package com.example.tradeapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    private lateinit var tabLabels: LinearLayout
    private lateinit var tabOpen: TextView
    private lateinit var tabExecuted: TextView
    private lateinit var tabIndicator: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tabLabels = findViewById(R.id.tabLabels)
        tabOpen = findViewById(R.id.tabOpen)
        tabExecuted = findViewById(R.id.tabExecuted)
        tabIndicator = findViewById(R.id.tabIndicator)

        //Wait until layout measured, then select default tab
        tabLabels.post {
            selectTab(0, animate = false)
        }
        tabOpen.setOnClickListener {
            selectTab(0, animate = true)
        }
        tabExecuted.setOnClickListener {
            selectTab(1, animate = true)
        }
    }

    private fun selectTab(index: Int, animate: Boolean) {
        val count = tabLabels.childCount
        if (count == 0) return

        // compute equal tab width (tabLabels uses weights so each tab is same width)
        val tabWidth = tabLabels.width / count
        val indicatorWidth = tabIndicator.width
        val targetX = index * tabWidth + (tabWidth - indicatorWidth) / 2f

        if (animate) {
            tabIndicator.animate()
                .translationX(targetX)
                .setDuration(180)
                .start()
        } else {
            tabIndicator.translationX = targetX
        }
        //update text color and styles
        if (index == 0) {
            tabOpen.setTextColor(Color.parseColor("#1976D2"))
            tabOpen.setTypeface(null, Typeface.BOLD)
            tabExecuted.setTextColor(Color.parseColor("#888888"))
            tabExecuted.setTypeface(null, Typeface.NORMAL)
        } else {
            tabExecuted.setTextColor(Color.parseColor("#1976D2"))
            tabExecuted.setTypeface(null, Typeface.BOLD)
            tabOpen.setTextColor(Color.parseColor("#888888"))
            tabOpen.setTypeface(null, Typeface.NORMAL)
        }
        //
        //for navigation

        findViewById<LinearLayout>(R.id.nav_watchlist).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
        findViewById<LinearLayout>(R.id.nav_orders).setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.nav_portfolio).setOnClickListener {
            startActivity(Intent(this, PortfolioActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}