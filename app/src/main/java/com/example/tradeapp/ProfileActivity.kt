package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    private var impsPopup: PopupWindow?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

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
        /*
        val tvFunds=findViewById<TextView>(R.id.funds)
        tvFunds.setOnClickListener {
            val intent=Intent(this,FundsActivity::class.java)
            startActivity(intent)
        }*/

        // Funds click
        findViewById<LinearLayout>(R.id.fundsLayout).setOnClickListener {
            startActivity(Intent(this, FundsActivity::class.java))
        }


        // Bank Details click
        findViewById<LinearLayout>(R.id.bankLayout).setOnClickListener {
            startActivity(Intent(this, BankDetailsActivity::class.java))
        }


        // Profile Details click
        findViewById<LinearLayout>(R.id.profileLayout).setOnClickListener {
            startActivity(Intent(this, ProfileDetailActivity::class.java))
        }

// KYC click
        findViewById<LinearLayout>(R.id.kycLayout).setOnClickListener {
            startActivity(Intent(this, KycDetailActivity::class.java))
        }
        val logoutLayout = findViewById<LinearLayout>(R.id.logoutLayout)
        logoutLayout.setOnClickListener {
            // 🔹 Open LogoutDialog when clicked
            /*val sessionManager = SessionManager(this)
            sessionManager.logout()  // clear session
            startActivity(Intent(this, LoginActivity::class.java)
                .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK })
            finish()
           */

            val dialog = LogoutDialog()
            dialog.show(supportFragmentManager, "LogoutDialog")
        }
        val impsLayout=findViewById<LinearLayout>(R.id.IMPSLayout)
        impsLayout.setOnClickListener {
            if(impsPopup !=null && impsPopup !!. isShowing){
                impsPopup!!.dismiss()
                impsPopup=null
            }else{
                showImpsPopup(it)
            }
        }

    }
    private fun showImpsPopup(anchorView: View) {
        val popupView = LayoutInflater.from(this).inflate(R.layout.popup_imps, null)
        impsPopup = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )
        // allow dismiss when clicking outside
        impsPopup!!.isOutsideTouchable = true
        impsPopup!!.setBackgroundDrawable(getDrawable(android.R.color.transparent))

        // 🔹 Find the "IMPS" TextView inside your LinearLayout
        val impsTextView = anchorView.findViewById<TextView>(R.id.IMPS)

        // show popup just below IMPS text
        val location = IntArray(2)
        impsTextView.getLocationOnScreen(location)

        // Calculate X and Y offsets
        val xOffset = location[0]
        val yOffset = location[1] + impsTextView.height

        // Show popup below the IMPS text
        impsPopup!!.showAtLocation(anchorView, Gravity.NO_GRAVITY, xOffset, yOffset)
        popupView.findViewById<TextView>(R.id.tvMobileRegistry).setOnClickListener {
            val intent=Intent(this, MobileRegistry::class.java)
            startActivity(intent)
            //Toast.makeText(this,"Mobile Registry Clicked",Toast.LENGTH_SHORT).show()
            impsPopup?.dismiss()
        }

        popupView.findViewById<TextView>(R.id.tvBeneficiary).setOnClickListener {
            val intent=Intent(this, AddBenificiary::class.java)
            startActivity(intent)
           // Toast.makeText(this,"Benificiary clicked", Toast.LENGTH_SHORT).show()
            impsPopup?.dismiss()
        }
        popupView.findViewById<TextView>(R.id.tvMoney).setOnClickListener {
            val intent=Intent(this, MoneyTransfer::class.java)
            startActivity(intent)
            //Toast.makeText(this,"IBMPS clicked",Toast.LENGTH_SHORT).show()
            impsPopup?.dismiss()
        }
    }
}


