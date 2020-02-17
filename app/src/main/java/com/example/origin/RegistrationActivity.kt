package com.example.origin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        register_button.setOnClickListener {
            val email = register_email.text.toString()
            val password = register_password.text.toString()

            Log.d("LoginActivity", "Email is $email")
            Log.d("LoginActivity", "Password is $password")

        }

        already_have.setOnClickListener {
            Log.d("LoginActivity","Already_have is pressed")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
