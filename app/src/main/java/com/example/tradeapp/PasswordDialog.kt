package com.example.tradeapp




import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class PasswordDialog(
    private val onPasswordEntered: (String) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Create an EditText for password input
        val input = EditText(requireContext()).apply {
            hint = "Enter Password"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        // Dialog is not cancelable
        isCancelable = false

        return AlertDialog.Builder(requireContext())
            .setTitle("Re-enter Password")
            .setView(input)
            .setPositiveButton("Submit") { _, _ ->
                val entered = input.text.toString()
                if (entered.isNotEmpty()) {
                    onPasswordEntered(entered)
                } else {
                    Toast.makeText(requireContext(), "Please enter a password", Toast.LENGTH_SHORT).show()
                    showAgain() // force user to enter password
                }
            }
            .setCancelable(false)
            .create()
    }

    private fun showAgain() {
        // Delay slightly to avoid FragmentManager issues
        dialog?.dismiss()
        PasswordDialog(onPasswordEntered).show(parentFragmentManager, "PasswordDialog")
    }
}

/*
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class PasswordDialog(
    val onPasswordEntered: (String) -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val input = EditText(requireContext())
        input.hint = "Enter Password"

        val session = SessionManager(requireContext())

        return AlertDialog.Builder(requireContext())
            .setTitle("Re-enter Password")
            .setView(input)
            .setCancelable(false) // cannot dismiss by tapping outside
            .setPositiveButton("Submit") { _, _ ->
                val entered = input.text.toString()
                if (entered == session.getPassword()) {
                    // Correct password → call callback
                    onPasswordEntered(entered)
                    dismiss()
                } else {
                    // Wrong password → show message, keep dialog open
                    Toast.makeText(requireContext(), "Wrong password! Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
            .create()
    }
}

 */
