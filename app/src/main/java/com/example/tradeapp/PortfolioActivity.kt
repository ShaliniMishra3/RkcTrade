package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.Adapter.PortfolioStockAdapter
import com.example.tradeapp.model.Stock

class PortfolioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView=findViewById<RecyclerView>(R.id.portfolioRecycler)
         recyclerView.layoutManager=LinearLayoutManager(this)
        /*
         val stockList=listOf(
             Stock("3019", "1.31", "-30.93%", "BIOGEN", "3,977.41", false, "0.91", "(-1.09%)"),
             Stock("1890", "0.88", "-34.09%", "GODHA-BE", "1,663.20", true, "0.58", "(-1.69%)"),
             Stock("1100", "0.79", "-1.27%", "JOHNPHARMA", "869.00", false, "0.78", "(0.00%)"),
             Stock("655", "4.05", "+17.52%", "PHEI", "2,650.00", false, "4.76", "(+0.50%)")
         )*/
        // Dummy data for testing
        val stockList = listOf(
            Stock("3019", "1.31", "BIOGEN", "-30.93%", "-1,230.12", "3,977.41", "0.91 (-1.09%)"),
            Stock("1890", "0.88", "GODHA-BE", "-34.09%", "-567.50", "1,663.20", "0.58 (-1.69%)"),
            Stock("1100", "0.79", "JOHNPHARMA", "-1.27%", "-11.00", "869.00", "0.78 (0.00%)"),
            Stock("655", "4.05", "PHEI", "+17.52%", "+460.00", "2,650.00", "4.76 (+0.50%)") ,
            Stock("655", "4.05", "PHEI", "+17.52%", "+460.00", "2,650.00", "4.76 (+0.50%)")
        )
        val adapter=PortfolioStockAdapter(stockList)
        recyclerView.adapter=adapter

        //for navigation

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

   // Underline the text
        val holdingsTab = findViewById<TextView>(R.id.holdingsTab)
        val positionsTab = findViewById<TextView>(R.id.positionsTab)
        val holdingsUnderline = findViewById<View>(R.id.holdingsUnderline)
        val positionsUnderline = findViewById<View>(R.id.positionsUnderline)

// Default: Holdings active
        holdingsUnderline.visibility = View.VISIBLE
        positionsUnderline.visibility = View.GONE

        holdingsTab.setOnClickListener {
            holdingsUnderline.visibility = View.VISIBLE
            positionsUnderline.visibility = View.GONE
            holdingsTab.setTextColor(ContextCompat.getColor(this, R.color.blue))
            positionsTab.setTextColor(ContextCompat.getColor(this, R.color.black))
        }

        positionsTab.setOnClickListener {
            positionsUnderline.visibility = View.VISIBLE
            holdingsUnderline.visibility = View.GONE
            positionsTab.setTextColor(ContextCompat.getColor(this, R.color.blue))
            holdingsTab.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


    }
}