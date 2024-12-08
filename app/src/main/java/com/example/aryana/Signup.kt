package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aryana.databinding.ActivitySignupBinding


class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.haveaccount.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }


        binding.signup.setOnClickListener {
            val email = binding.userEmail.text.toString()
            val password = binding.Password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty())
                profile.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, Login::class.java))
                            finish()
                        }
                    }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
                }
        }
    }



}