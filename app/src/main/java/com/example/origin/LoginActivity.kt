package com.example.origin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = email.text.toString()
        val password = password.text.toString()

        Log.d("LoginActivity","Email is " + email)
        Log.d("LoginActivity", "Email is " + password)

    }
}
