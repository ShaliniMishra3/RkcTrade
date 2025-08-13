package com.example.tradeapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.R
import com.example.tradeapp.model.Stock

class PortfolioStockAdapter(private val stocks: List<Stock>):RecyclerView.Adapter<PortfolioStockAdapter.StockViewHolder>(){
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PortfolioStockAdapter.StockViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.portfolio_item_stock,parent)
       return StockViewHolder(view)
    }

  inner class StockViewHolder(view: View):RecyclerView.ViewHolder(view){
      val tvQtyAvg:TextView=view.findViewById(R.id.tvQtyAvg)
      val tvPercentChange:TextView=view.findViewById(R.id.tvPercentChange)
      val tvStockName:TextView=view.findViewById(R.id.tvStockName)
      val tvInvested:TextView=view.findViewById(R.id.tvInvested)
      val tvEvent:TextView=view.findViewById(R.id.tvEvent)
      val tvLtp:TextView=view.findViewById(R.id.tvLtp)
      val tvChange:TextView=view.findViewById(R.id.tvChange)
  }

    override fun onBindViewHolder(holder: PortfolioStockAdapter.StockViewHolder, position: Int) {
        val stock=stocks[position]
        holder.tvQtyAvg.text = "Qty. ${stock.qty} • Avg. ${stock.avg}"
        holder.tvPercentChange.text = stock.percentChange
        holder.tvStockName.text = stock.name
        holder.tvInvested.text = "Invested ${stock.invested}"
        holder.tvEvent.visibility = if (stock.event) View.VISIBLE else View.GONE
        holder.tvLtp.text = "LTP ${stock.ltp}"
        holder.tvChange.text = stock.change
    }

    override fun getItemCount()=stocks.size

}