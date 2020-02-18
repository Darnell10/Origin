package com.example.origin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            val loginEmail = login_email.text.toString()
            val loginPassword = login_password.text.toString()

            Log.d("LoginActivity", "Attempt to login with $loginEmail")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(loginEmail,loginPassword)

        }

        need_to_register.setOnClickListener {
            Log.d("LoginActivity","I need to register")
            finish()
        }
    }
}
