package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.Adapter.LaunchStockAdapter
import retrofit2.Call


class LaunchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LaunchStockAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launch)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val launchText = findViewById<TextView>(R.id.launchText)
        launchText.setOnClickListener {
            startActivity(Intent(this, LaunchActivity::class.java))
        }
        val currentWatchlistText = findViewById<TextView>(R.id.currentWatchlistText)
        currentWatchlistText.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish() // close current screen
            startActivity(intent) // reload MainActivity
        }
        recyclerView = findViewById(R.id.stockRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        /*
        val stockList = listOf(
            StockItem("Property A", "Lucknow", "24,427.45", "INDICES"),
            StockItem("Property B", "Lucknow", "55,157.10", "INDICES"),
            StockItem("Property C", "Lucknow", "1,374.20", "NSE",),
            StockItem("Property D", "Ayodhya", "158.26", "NSE"),
            StockItem("Property E", "Ayodhya", "433.15", "NSE"),
            StockItem("Property F", "Madurai", "421.75", "NSE"),
            StockItem("Property G", "Kanpur", "274.55", "Indices"),
            StockItem("Property H", "Kanpur", "158.26", "NSE"),
            StockItem("Property I", "Kanpur", "158.26", "NSE"),
            StockItem("Property J", "Lucknow", "158.26", "NSE"),
            StockItem("Property K", "Kanpur", "158.26", "Indices"),
        )

       adapter = LaunchStockAdapter(stockList)
        recyclerView.adapter = adapter
        */
        // ✅ Use dynamic list with API data
        adapter = LaunchStockAdapter(emptyList()) // Initially empty
        recyclerView.adapter = adapter

        // ✅ Fetch property list from API
        fetchPropertyList()
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

    private fun fetchPropertyList() {
        val requestBody = PropertyRequest(propertyId = "0")
        Log.d("API_DEBUG", "Sending: ${requestBody.propertyId}")
        RetrofitClient.instance.getProperties(requestBody).enqueue(object : retrofit2.Callback<PropertyResponse> {
            override fun onResponse(call: Call<PropertyResponse>, response: retrofit2.Response<PropertyResponse>) {
                if (response.isSuccessful && response.body()?.data != null) {
                    val propertyList = response.body()!!.data
                    adapter.updateList(propertyList)  // Assuming adapter is already initialized
                    Log.d("API_DEBUG", "Received items: ${propertyList.size}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("API_ERROR", "Code: ${response.code()}, ErrorBody: $errorBody")
                }
            }

            override fun onFailure(call: Call<PropertyResponse>, t: Throwable) {
                Log.e("API_ERROR", "Failure: ${t.message}")
            }
        })
        /*
        val request =  PropertyRequest(propertyId = 0)
        RetrofitClient.instance.getProperties(request).enqueue(object : Callback<PropertyResponse> {
            override fun onResponse(call: Call<PropertyResponse>, response: Response<PropertyResponse>) {
                if (response.isSuccessful && response.body()?.data != null) {
                    val propertyList = response.body()!!.data
                    adapter = LaunchStockAdapter(propertyList)
                    recyclerView.adapter = adapter
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("API_ERROR", "Response failed")
                    Log.e("API_ERROR", "Code: ${response.code()}")
                    Log.e("API_ERROR", "ErrorBody: $errorBody") // 👈 This helps identify what's wrong
                }
            }

            override fun onFailure(call: Call<PropertyResponse>, t: Throwable) {
                Log.e("API", "Failure: ${t.message}")
            }
        })

         */
    }

    /*
    private fun fetchPropertyList() {
        val body = mapOf("PropertyId" to "0")
        RetrofitClient.instance.getProperties(body).enqueue(object : Callback<PropertyResponse> {
            override fun onResponse(call: Call<PropertyResponse>, response: Response<PropertyResponse>) {
                if (response.isSuccessful) {
                    val properties = response.body()?.data ?: emptyList()
                    adapter.updateList(properties)
                } else {
                    Toast.makeText(this@LaunchActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PropertyResponse>, t: Throwable) {
                Toast.makeText(this@LaunchActivity, "API failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

     */



}


