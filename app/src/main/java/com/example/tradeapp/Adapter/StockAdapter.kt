package com.example.tradeapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tradeapp.R
import com.example.tradeapp.StockBottomSheet
import com.example.tradeapp.model.StockItem

class StockAdapter(private val stocks:List<StockItem>):
    RecyclerView.Adapter<StockAdapter.StockViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StockViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_stock,parent,false)
        return StockViewHolder(view)

    }

    class StockViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val name:TextView=view.findViewById(R.id.textStockName)
        val exchange: TextView =view.findViewById(R.id.textStockExchange)
        val price:TextView=view.findViewById(R.id.textStockPrice)
        val change:TextView=view.findViewById(R.id.textStockChange)

        val separatorLine: View = itemView.findViewById(R.id.separatorLine)




    }
    override fun onBindViewHolder(holder: StockAdapter.StockViewHolder, position: Int) {

        val item=stocks[position]
        holder.name.text=item.name
        holder.exchange.text=item.exchange
        holder.price.text=item.price
        holder.change.text=item.change

        // Hide line for the last item
        if (position == stocks.size - 1) {
            holder.separatorLine.visibility = View.GONE
        } else {
            holder.separatorLine.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            val bottomSheet = StockBottomSheet()
            bottomSheet.show((it.context as AppCompatActivity).supportFragmentManager, "StockBottomSheet")
        }

    }

    override fun getItemCount(): Int=stocks.size

}