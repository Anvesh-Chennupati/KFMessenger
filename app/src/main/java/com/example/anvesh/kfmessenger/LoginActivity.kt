package com.example.anvesh.kfmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            performLogin()
        }

        back_to_register_textview.setOnClickListener {
            finish()
        }
    }

    private fun performLogin() {


        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        Log.d("Login", "Attempt login with email/pw: $email/***")

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if successful
                Log.d("Main", "Successfully created user with uid: ${it.result.user.uid}")
                Toast.makeText(this, "Successfully logged In", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Log.d("Main", "Failed to Login User: ${it.message}")
                Toast.makeText(this, "Failed to login user: ${it.message}", Toast.LENGTH_SHORT).show()
            }

    }

}