package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.Adapter.StockAdapter
import com.example.tradeapp.model.StockItem

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StockAdapter
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        session = SessionManager(this)
        setupRecyclerView()
        setupNavigation()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.stockRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val stockList = listOf(
            StockItem("Property A", "Lucknow", "24,427.45", "INDICES"),
            StockItem("Property B", "Lucknow", "55,157.10", "INDICES"),
            StockItem("Property C", "Lucknow", "1,374.20", "NSE"),
            StockItem("Property D", "Ayodhya", "158.26", "NSE"),
            StockItem("Property E", "Ayodhya", "433.15", "NSE"),
            StockItem("Property F", "Madurai", "421.75", "NSE"),
            StockItem("Property G", "Kanpur", "274.55", "Indices"),
            StockItem("Property H", "Kanpur", "158.26", "NSE"),
            StockItem("Property I", "Kanpur", "158.26", "NSE"),
            StockItem("Property J", "Lucknow", "158.26", "NSE"),
            StockItem("Property K", "Kanpur", "158.26", "Indices")
        )

        adapter = StockAdapter(stockList) { stock, _ ->
            val bottomSheet = StockBottomSheet(stock)
            bottomSheet.show(supportFragmentManager, "StockBottomSheet")
        }
        recyclerView.adapter = adapter
    }

    private fun setupNavigation() {
        val navWatchlist = findViewById<LinearLayout>(R.id.nav_watchlist)
        val navOrders = findViewById<LinearLayout>(R.id.nav_orders)
        val navPortfolio = findViewById<LinearLayout>(R.id.nav_portfolio)
        val navProfile = findViewById<LinearLayout>(R.id.nav_profile)

        val allNavItems = listOf(navWatchlist, navOrders, navPortfolio, navProfile)

        // Set default highlight (Current: Watchlist)
        highlightSelectedNav(navWatchlist, allNavItems)

        // Click listeners for each item
        navWatchlist.setOnClickListener {
            highlightSelectedNav(navWatchlist, allNavItems)
            // No navigation needed since it's current screen
        }

        navOrders.setOnClickListener {
            highlightSelectedNav(navOrders, allNavItems)
            startActivity(Intent(this, OrderActivity::class.java))
            finish()
        }

        navPortfolio.setOnClickListener {
            highlightSelectedNav(navPortfolio, allNavItems)
            startActivity(Intent(this, PortfolioActivity::class.java))
            finish()
        }

        navProfile.setOnClickListener {
            highlightSelectedNav(navProfile, allNavItems)
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        // Launch button at top
        findViewById<TextView>(R.id.launchText).setOnClickListener {
            startActivity(Intent(this, LaunchActivity::class.java))
        }
    }

    private fun highlightSelectedNav(selectedItem: LinearLayout, allItems: List<LinearLayout>) {
        val blue = getColor(R.color.blue) // You can define #2196F3 in colors.xml as blue_500
        val gray = getColor(android.R.color.darker_gray)

        for (item in allItems) {
            val icon = item.getChildAt(0) as ImageView
            val label = item.getChildAt(1) as TextView

            if (item == selectedItem) {
                icon.setColorFilter(blue)
                label.setTextColor(blue)
            } else {
                icon.setColorFilter(gray)
                label.setTextColor(gray)
            }
        }


    }}








