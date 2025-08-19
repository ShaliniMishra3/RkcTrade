package com.example.tradeapp

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class AddFunds : AppCompatActivity() {private lateinit var etUtrNo: EditText
    private lateinit var etAmount: EditText
    private lateinit var btnChooseFile: Button
    private lateinit var etPaymentDate: EditText
    private lateinit var etRemark: EditText
    private lateinit var btnSubmit: Button
    private var selectedFileUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_funds)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etUtrNo = findViewById(R.id.etUtrNo)
        etAmount = findViewById(R.id.etAmount)
        btnChooseFile = findViewById(R.id.btnChooseFile)
        etPaymentDate = findViewById(R.id.etPaymentDate)
        etRemark = findViewById(R.id.etRemark)
        btnSubmit = findViewById(R.id.btnSubmit)

        // 📅 Date Picker
        etPaymentDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, y, m, d ->
                    etPaymentDate.setText("$d/${m + 1}/$y")
                }, year, month, day
            )
            datePicker.show()
        }

        // 📂 File Picker
        btnChooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(Intent.createChooser(intent, "Select Payment Proof"), 101)
        }

        // ✅ Submit button
        btnSubmit.setOnClickListener {
            val utr = etUtrNo.text.toString()
            val amount = etAmount.text.toString()
            val date = etPaymentDate.text.toString()
            val remark = etRemark.text.toString()

            Toast.makeText(this, "Submitted:\nUTR:$utr\nAmount:$amount\nDate:$date\nRemark:$remark", Toast.LENGTH_LONG).show()
        }
        // 🔙 Back button click
        val backBtn: ImageView = findViewById(R.id.ivBack)
        backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val btnSubmit=findViewById<Button>(R.id.btnSubmit)
        btnSubmit.backgroundTintList=null
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101 && resultCode == RESULT_OK) {
            selectedFileUri = data?.data
            btnChooseFile.text = "File Selected"
        }
    }
}