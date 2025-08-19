package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class LogoutDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.logout_dialog, container, false)
        val btnCancel = view.findViewById<Button>(R.id.btnCancelLogout)

        val btnConfirm = view.findViewById<Button>(R.id.btnConfirmLogout)
        // Cancel → just close popup
        btnCancel.setOnClickListener {
            dismiss()
        }
        // Confirm → handle logout

        // Confirm → handle logout
        /*
        btnConfirm.setOnClickListener {
            activity?.let { act ->
                val sessionManager = SessionManager(act)
                sessionManager.logout() // ✅ clear session

                // Go back to login activity
                val intent = Intent(act, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                act.finish() // close current activity
            }
            dismiss()
        }

         */
        // Confirm → handle logout
        btnConfirm.setOnClickListener {
            activity?.let { act ->
                val sessionManager = SessionManager(act)
                sessionManager.logout() // ✅ clear login session
                // Go to LoginActivity and clear all previous activities
                val intent = Intent(act, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                // Finish current activity
                act.finish()
            }
            dismiss()
        }

        return view
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.85).toInt(),
           // ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}