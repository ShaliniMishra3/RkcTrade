package com.example.tradeapp

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
       // passwordEditText = findViewById(R.id.passwordEditText)
       val signUpTextView = findViewById<TextView>(R.id.signUpTextView)
        signUpTextView.text = Html.fromHtml("Don't have account? <font color='#3F51B5'><b>Sign In</b></font>", Html.FROM_HTML_MODE_LEGACY)
        signUpTextView.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       // Init session manager
     sessionManager = SessionManager(this)
       // 🔹 If already logged in → skip login


       if (sessionManager.isLoggedIn()) {
           startActivity(Intent(this, MainActivity::class.java))
           finish()
           return
       }


       etUsername = findViewById(R.id.emailEditText)
       etPassword = findViewById(R.id.passwordEditText)
       btnLogin = findViewById(R.id.loginButton)

    // loginButton=findViewById<Button>(R.id.loginButton)
        btnLogin.backgroundTintList = null
        btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        val forgetPassword=findViewById<TextView>(R.id.ForgetPassword)
        forgetPassword.setOnClickListener {
            startActivity(Intent(this,ForgetPasswordActivity::class.java))

        }
       // Handle login button click
       btnLogin.setOnClickListener {
           val username = etUsername.text.toString().trim()
           val password = etPassword.text.toString().trim()

           if (username.isEmpty() || password.isEmpty()) {
               Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
           } else {
               loginUser(username, password)
           }
       }

    }
    private fun loginUser(username: String, password: String) {
      val request = LoginRequest(MainId = username, Password = password)

      ApiClient.instance.loginUser("9DFD7FDA-MNBO-45", request)
          .enqueue(object : Callback<LoginResponse> {
              override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                  if (response.isSuccessful && response.body() != null) {
                      try {
                          val outer = response.body()!!
                          val gson = Gson()
                          val inner = gson.fromJson(outer.data, InnerResponse::class.java)
                          val user = inner.data.firstOrNull()

                          if (user != null && user.result_status == 1) {
                              Toast.makeText(this@LoginActivity, user.msg, Toast.LENGTH_SHORT).show()
                              // ✅ Save session
// ✅ Save session (this is the missing line)

                             sessionManager.saveLogin(username, "dummy_token",password)

                              // if API gives you JWT or AuthToken, replace "dummy_token" with it
                              startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                              finish()
                          } else {
                              Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                          }
                      } catch (e: Exception) {
                          e.printStackTrace()
                          Toast.makeText(this@LoginActivity, "Parsing error", Toast.LENGTH_SHORT).show()
                      }
                  } else {
                      Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                  }
              }

              override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                  Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
              }
          })
  }

}