package com.example.tradeapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.R
import com.example.tradeapp.model.Stock

class PortfolioStockAdapter(private var stocks: List<Stock>):RecyclerView.Adapter<PortfolioStockAdapter.StockViewHolder>(){
    data class ListStock (
        val qty:String,
        val avg:String,
        val percentChange:String,
        val name:String,
        val invested:String,
        val event:Boolean,
        val ltp:String,
        val change:String

    )
    fun updateData(newStocks: List<Stock>) {
        stocks = newStocks
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PortfolioStockAdapter.StockViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.portfolio_item_stock,parent,false)
       return StockViewHolder(view)
    }

  inner class StockViewHolder(view: View):RecyclerView.ViewHolder(view){

   val tvQty: TextView = view.findViewById(R.id.qtyText)
      val tvAvg: TextView = view.findViewById(R.id.avgText)
      val tvStockName: TextView = view.findViewById(R.id.stockName)
      val tvPercentChange: TextView = view.findViewById(R.id.percentageText)
      val tvPL: TextView = view.findViewById(R.id.plText)
      val tvInvested: TextView = view.findViewById(R.id.investedText)
      val tvLtp: TextView = view.findViewById(R.id.ltpText)

  }

    override fun onBindViewHolder(holder: PortfolioStockAdapter.StockViewHolder, position: Int) {

        val stock=stocks[position]

        // Qty & Avg
        holder.tvQty.text = "Qty. ${stock.qty}"
        holder.tvAvg.text = "Avg. ${stock.avg}"

        // Stock Name
        holder.tvStockName.text = stock.name

        // Percent Change & P&L (red if negative, green if positive)
        holder.tvPercentChange.text = stock.percentChange
        holder.tvPL.text = stock.pl

        try {
            val percent = stock.percentChange.replace("%", "").toDouble()
            if (percent < 0) {
                // loss → red
                holder.tvPercentChange.setTextColor(holder.itemView.context.getColor(android.R.color.holo_red_dark))
                holder.tvPL.setTextColor(holder.itemView.context.getColor(android.R.color.holo_red_dark))
            } else {
                // profit → green
                holder.tvPercentChange.setTextColor(holder.itemView.context.getColor(android.R.color.holo_green_dark))
                holder.tvPL.setTextColor(holder.itemView.context.getColor(android.R.color.holo_green_dark))
            }
        } catch (_: Exception) { }

        // Invested & LTP
        holder.tvInvested.text = "Invested ${stock.invested}"
        holder.tvLtp.text = "LTP ${stock.ltp}"

    }

    override fun getItemCount()=stocks.size

}