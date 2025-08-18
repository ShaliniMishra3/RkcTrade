package com.example.tradeapp

import android.content.Intent

import android.os.Bundle
import android.widget.LinearLayout
import com.example.tradeapp.Adapter.StockAdapter
import com.example.tradeapp.StockItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:StockAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // val profileIcon: item =findViewById(R.id.nav_profile)
        recyclerView = findViewById(R.id.stockRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val stockList = listOf(
            StockItem("Property A", "INDICES", "24,427.45", "Lucknow"),
            StockItem("Property B", "INDICES", "55,157.10", "Lucknow"),
            StockItem("Property C", "NSE", "1,374.20", "Lucknow"),
            StockItem("Property D", "NSE", "158.26", "Ayodhya"),
            StockItem("Property E", "NSE", "433.15", "Ayodhya"),
            StockItem("Property F", "NSE", "421.75", "Mathura"),
            StockItem("Property G", "NSE", "274.55", "Mathura"),
            StockItem("Property H", "NSE", "158.26", "Kanpur"),
            StockItem("Property I", "NSE", "158.26", "Kanpur"),
            StockItem("Property J", "NSE", "158.26", "Lucknow"),
            StockItem("Property K", "NSE", "158.26", "Kanpur"),



            )
        adapter =StockAdapter(stockList) // ✅ initialized before use
        recyclerView.adapter = adapter
/*

        val navMap = mapOf(
            R.id.nav_orders to OrderActivity::class.java,
            R.id.nav_portfolio to PortfolioActivity::class.java,
            R.id.nav_profile to ProfileActivity::class.java
        )


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            navMap[item.itemId]?.let {
                startActivity(Intent(this, it))
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    */
// Open BottomSheet only when item clicked

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


    }

}





