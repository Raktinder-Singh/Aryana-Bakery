package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aryana.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {
    private val binding: ActivityWelcomeBinding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginact.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.createact.setOnClickListener{
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}