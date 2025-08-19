package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.tradeapp.model.StockItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

class StockBottomSheet (private val stockItem: StockItem): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_stock_bottomsheet, container, false)
    }

    override fun onStart() {
        super.onStart()
        (dialog as? com.google.android.material.bottomsheet.BottomSheetDialog)
            ?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.background = ContextCompat.getDrawable(requireContext(), R.drawable.bg_bottomsheet_round)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("StockSheet", "StockBottomSheet opened")
        // 🔹 Dynamically set stock name and exchange info
        val stockNameTV = view.findViewById<TextView>(R.id.stockName)
        val stockExchangeTV = view.findViewById<TextView>(R.id.stockExchange)

        stockNameTV.text = stockItem.name
        stockExchangeTV.text = "${stockItem.exchange} ${stockItem.price}"

        // ✅ Find your BUY and SELL buttons here
        val buyBtn = view.findViewById<MaterialButton>(R.id.buyBtn)
        val sellBtn = view.findViewById<MaterialButton>(R.id.sellBtn)
        // ✅ Set click listeners
        buyBtn.setOnClickListener {
            val intent = Intent(requireContext(), BuyActivity::class.java)
            startActivity(intent)
            dismiss() // close bottomsheet
        }
        sellBtn.setOnClickListener {
            val intent = Intent(requireContext(), SellActivity::class.java)
            startActivity(intent)
            dismiss() // close bottomsheet
        }
    }

}

