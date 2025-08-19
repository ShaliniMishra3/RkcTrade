package com.example.tradeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetailActivity : AppCompatActivity() {
    private var selectedImageUri: Uri? = null
    private lateinit var imagePreview: ImageView

    private lateinit var cardProfileDetails: CardView
    private lateinit var cardEditProfile: CardView
    private lateinit var tvEdit: TextView
    private lateinit var tvProfileTitle: TextView
    private lateinit var backArrow: ImageView
    // ActivityResultLauncher for picking image
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            selectedImageUri = result.data?.data
            selectedImageUri?.let {
                imagePreview.setImageURI(it)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btnSelectImage: Button = findViewById(R.id.btnSelectImage)
        imagePreview = findViewById(R.id.imagePreview)

        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImageLauncher.launch(intent)
        }
        val profileDetail = findViewById<TextView>(R.id.btnSubmitProfile)
        profileDetail.backgroundTintList = null
        val editProfileDetail = findViewById<TextView>(R.id.btnSaveProfile)
        editProfileDetail.backgroundTintList = null
        findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        // 🔹 Launch button click
        val profileText = findViewById<TextView>(R.id.profileDetailText)
        profileText.setOnClickListener {
            val intent = Intent(this, ProfileDetailActivity::class.java)
            finish() // finish current activity
            startActivity(intent) // start again
        }
        val editProfileText = findViewById<TextView>(R.id.editProfile)
        editProfileText.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            finish() // close current screen
            startActivity(intent) //reload MainActivity
        }
//

        cardProfileDetails = findViewById(R.id.cardProfileDetails)
        cardEditProfile = findViewById(R.id.cardEditProfile)
        tvEdit = findViewById(R.id.editProfile)
        tvProfileTitle = findViewById(R.id.profileDetailText)
        backArrow = findViewById(R.id.backArrow)

        // Edit → show Edit Profile card
        tvEdit.setOnClickListener { showEdit() }

        // "Profile Detail" title → show Profile Detail card
        tvProfileTitle.setOnClickListener { showProfile() }

        // Back arrow: finish the activity (or change to showProfile() if you prefer)
        backArrow.setOnClickListener { finish() }


    }
    private fun showEdit() {
        cardProfileDetails.visibility = View.GONE
        cardEditProfile.visibility = View.VISIBLE
        // top bar texts remain unchanged per your requirement
    }

    private fun showProfile() {
        cardEditProfile.visibility = View.GONE
        cardProfileDetails.visibility = View.VISIBLE
        // top bar texts remain unchanged per your requirement
    }

}