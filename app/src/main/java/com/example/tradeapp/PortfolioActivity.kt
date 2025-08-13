package com.example.tradeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        val recyclerView=findViewById<RecyclerView>(R.id.stockRecyclerView)
         recyclerView.layoutManager=LinearLayoutManager(this)
         val stockList=listOf(
             Stock("3019", "1.31", "-30.93%", "BIOGEN", "3,977.41", false, "0.91", "(-1.09%)"),
             Stock("1890", "0.88", "-34.09%", "GODHA-BE", "1,663.20", true, "0.58", "(-1.69%)"),
             Stock("1100", "0.79", "-1.27%", "JOHNPHARMA", "869.00", false, "0.78", "(0.00%)"),
             Stock("655", "4.05", "+17.52%", "PHEI", "2,650.00", false, "4.76", "(+0.50%)")
         )
        val adapter=PortfolioStockAdapter(stockList)
        recyclerView.adapter=adapter


    }
}