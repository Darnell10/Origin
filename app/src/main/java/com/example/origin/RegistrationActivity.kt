package com.example.origin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        register_button.setOnClickListener {
            registration()

        }

        already_have.setOnClickListener {
            Log.d("RegisterActivity", "Already_have is pressed")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun registration() {
        val email = register_email.text.toString()
        val password = register_password.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this, "Please Enter both Email and Password",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        Log.d("RegisterActivity", "Email is $email")
        Log.d("RegisterActivity", "Password is $password")

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener
                Log.d("RegistrationActivity", " New User ${it.result?.user?.uid} ")
                saveUserToFireBaseDatabase()
            }
            .addOnFailureListener {
                Log.d("Registration", "${it.message}")
                Toast.makeText(this, "No User Created ${it.message}", Toast.LENGTH_LONG).show()
            }
    }


    private fun saveUserToFireBaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid, userName.text.toString())

        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("RegistrationActivity", "Saved user to FireBase")
            }
    }

    class User(val uid: String? = "", val userName: String? = "")
}