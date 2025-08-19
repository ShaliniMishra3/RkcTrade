package com.example.tradeapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tradeapp.model.PropertyItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LaunchStockBottomSheetFragment(private val propertyItem: PropertyItem) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.launch_stock_bottom_sheet_fragment, container, false)
        val propertyName = view.findViewById<TextView>(R.id.propertyName)
        val propertyRate = view.findViewById<TextView>(R.id.propertyRate)
        val propertyValue = view.findViewById<TextView>(R.id.propertyValue)
        val quantityInput = view.findViewById<EditText>(R.id.quantityInput)
        val propertyAmount = view.findViewById<EditText>(R.id.propertyAmount)
        val finalAmount = view.findViewById<EditText>(R.id.finalAmount)

        val submitButton = view.findViewById<Button>(R.id.submitButton)

        propertyName.text = propertyItem.propertyName
        propertyRate.text = "Rate: ${propertyItem.rate.toString()}"
        propertyValue.text = "Balance Unit: ${propertyItem.balanceArea}"
        quantityInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val qtyText = s.toString()
                val quantity = if (qtyText.isNotEmpty()) qtyText.toInt() else 0
                val rate = propertyItem.rate.toInt()
                // 🔹 Multiply rate × quantity
                val propertyAmt = quantity * rate
                propertyAmount.setText(propertyAmt.toString())
                // 🔹 Calculate 0.25% of property amount
                val finalAmt = (propertyAmt * 0.25) / 100
                finalAmount.setText(finalAmt.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        //  propertyAddress.text = propertyItem.Property_Address
        submitButton.setOnClickListener {
            dismiss()
        }
        return view
    }
}

