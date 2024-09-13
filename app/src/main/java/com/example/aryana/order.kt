package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aryana.databinding.ActivityOrderBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class order : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.search

        bottomNavigationView.setOnItemSelectedListener{
                menuItem ->
            when(menuItem.itemId){
                R.id.home_bottom ->  {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cart_bottom -> {
                    val intent = Intent(this, Cart::class.java)
                    startActivity(intent)
                    true
                }

                R.id.search -> true
                R.id.profile_bottom -> {
                    val intent = Intent(this, profile::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}