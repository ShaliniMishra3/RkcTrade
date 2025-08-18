package com.example.tradeapp

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar

import android.widget.TextView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FundsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_funds)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Handle back button
            /*
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        */
            
        // 🔹 First set row labels dynamically
        /*
        setupFundLabels()

        setFundsData(
            availableMargin = "₹0.00",
            availableCash = "0.00",
            usedMargin = "0.00",
            openingBalance = "0.00",
            payin = "0.00",
            payout = "0.00",
            span = "0.00",
            deliveryMargin = "0.00",
            exposure = "0.00",
            optionPremium = "0.00",
            collateralLiquid = "0.00",
            collateralEquity = "0.00",
            totalCollateral = "0.00"
        )
    }
    // ✅ Step 1: Setup labels using `android:tag`
    private fun setupFundLabels() {
        val rowIds = listOf(
            R.id.rowOpeningBalance,
            R.id.rowPayin,
            R.id.rowPayout,
            R.id.rowSPAN,
            R.id.rowDeliveryMargin,
            R.id.rowExposure,
            R.id.rowOptionPremium,
            R.id.rowCollateralLiquid,
            R.id.rowCollateralEquity,
            R.id.rowTotalCollateral
        )

        for (rowId in rowIds) {
            val row = findViewById<LinearLayout>(rowId)
            val label = row.tag as? String ?: ""   // read tag from XML
            row.findViewById<TextView>(R.id.tvLabel).text = label
        }
    }


    private fun setFundsData(
        availableMargin: String,
        availableCash: String,
        usedMargin: String,
        openingBalance: String,
        payin: String,
        payout: String,
        span: String,
        deliveryMargin: String,
        exposure: String,
        optionPremium: String,
        collateralLiquid: String,
        collateralEquity: String,
        totalCollateral: String
    ) {
        findViewById<TextView>(R.id.tvAvailableMargin).text = availableMargin
        findViewById<TextView>(R.id.tvAvailableCash).text = availableCash
        findViewById<TextView>(R.id.tvUsedMargin).text = usedMargin

//        findViewById<TextView>(R.id.rowOpeningBalance).findViewById<TextView>(R.id.tvValue).text = openingBalance
        findViewById<LinearLayout>(R.id.rowOpeningBalance)
            .findViewById<TextView>(R.id.tvValue).text = openingBalance
        findViewById<LinearLayout>(R.id.rowPayin).findViewById<TextView>(R.id.tvValue).text = payin
        findViewById<LinearLayout>(R.id.rowPayout).findViewById<TextView>(R.id.tvValue).text = payout
        findViewById<LinearLayout>(R.id.rowSPAN).findViewById<TextView>(R.id.tvValue).text = span
        findViewById<LinearLayout>(R.id.rowDeliveryMargin).findViewById<TextView>(R.id.tvValue).text = deliveryMargin
        findViewById<LinearLayout>(R.id.rowExposure).findViewById<TextView>(R.id.tvValue).text = exposure
        findViewById<LinearLayout>(R.id.rowOptionPremium).findViewById<TextView>(R.id.tvValue).text = optionPremium
        findViewById<LinearLayout>(R.id.rowCollateralLiquid).findViewById<TextView>(R.id.tvValue).text = collateralLiquid
        findViewById<LinearLayout>(R.id.rowCollateralEquity).findViewById<TextView>(R.id.tvValue).text = collateralEquity
        findViewById<LinearLayout>(R.id.rowTotalCollateral).findViewById<TextView>(R.id.tvValue).text = totalCollateral
/*
        findViewById<TextView>(R.id.rowPayin).findViewById<TextView>(R.id.tvValue).text = payin
        findViewById<TextView>(R.id.rowPayout).findViewById<TextView>(R.id.tvValue).text = payout
        findViewById<TextView>(R.id.rowSPAN).findViewById<TextView>(R.id.tvValue).text = span
        findViewById<TextView>(R.id.rowDeliveryMargin).findViewById<TextView>(R.id.tvValue).text = deliveryMargin
        findViewById<TextView>(R.id.rowExposure).findViewById<TextView>(R.id.tvValue).text = exposure
        findViewById<TextView>(R.id.rowOptionPremium).findViewById<TextView>(R.id.tvValue).text = optionPremium
        findViewById<TextView>(R.id.rowCollateralLiquid).findViewById<TextView>(R.id.tvValue).text = collateralLiquid
        findViewById<TextView>(R.id.rowCollateralEquity).findViewById<TextView>(R.id.tvValue).text = collateralEquity
        findViewById<TextView>(R.id.rowTotalCollateral).findViewById<TextView>(R.id.tvValue).text = totalCollateral
   */
*/

    }

}