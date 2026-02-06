package com.example.tradeapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.LaunchStockBottomSheetFragment
import com.example.tradeapp.R
import com.example.tradeapp.model.PropertyItem

class LaunchStockAdapter(
    private var properties: List<PropertyItem>
) : RecyclerView.Adapter<LaunchStockAdapter.LaunchStockViewHolder>() {

    class LaunchStockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textStockName)
        val exchange: TextView = view.findViewById(R.id.textStockExchange)
        val price: TextView = view.findViewById(R.id.textStockPrice)
        val change: TextView = view.findViewById(R.id.textStockChange)
        val separatorLine: View = view.findViewById(R.id.separatorLine)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchStockViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stock, parent, false)
        return LaunchStockViewHolder(view)
    }
    override fun onBindViewHolder(holder: LaunchStockViewHolder, position: Int) {
        val item = properties[position]
        holder.name.text = item.propertyName
        holder.exchange.text = item.propertyAddress
        holder.price.text = item.rate.toString()


        holder.change.text = if (position % 2 == 0) "NSE" else "INDICES"


        holder.separatorLine.visibility =
            if (position == properties.size - 1) View.GONE else View.VISIBLE


        holder.itemView.setOnClickListener {
            val bottomSheet = LaunchStockBottomSheetFragment(item) // remove item if not used
            bottomSheet.show(
                (it.context as AppCompatActivity).supportFragmentManager,
                "LaunchStockBottomSheet"
            )
        }
    }

    override fun getItemCount(): Int = properties.size
    fun updateList(newList: List<PropertyItem>) {
        properties = newList
        notifyDataSetChanged()
    }
}


/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.LaunchStockBottomSheetFragment
import com.example.tradeapp.R
import com.example.tradeapp.model.StockItem

class LaunchStockAdapter(
    private val stocks: List<StockItem>
) : RecyclerView.Adapter<LaunchStockAdapter.LaunchStockViewHolder>() {

    class LaunchStockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textStockName)
        val exchange: TextView = view.findViewById(R.id.textStockExchange)
        val price: TextView = view.findViewById(R.id.textStockPrice)
        val change: TextView = view.findViewById(R.id.textStockChange)
        val separatorLine: View = view.findViewById(R.id.separatorLine)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchStockViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stock, parent, false)
        return LaunchStockViewHolder(view)
    }
    override fun onBindViewHolder(holder: LaunchStockViewHolder, position: Int) {
        val item = stocks[position]
        holder.name.text = item.name
        holder.exchange.text = item.exchange
        holder.price.text = item.price
        holder.change.text = item.change

        holder.separatorLine.visibility = if (position == stocks.size - 1) View.GONE else View.VISIBLE

        holder.itemView.setOnClickListener {
            val bottomSheet = LaunchStockBottomSheetFragment(item)
            bottomSheet.show(
                (it.context as AppCompatActivity).supportFragmentManager,
                "LaunchStockBottomSheet"
            )
        }
    }

    override fun getItemCount(): Int = stocks.size
}
*/

