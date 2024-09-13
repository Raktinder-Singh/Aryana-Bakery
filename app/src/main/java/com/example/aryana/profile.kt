package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aryana.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.profile_bottom


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

                R.id.search -> {
                    val intent = Intent(this, order::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile_bottom -> true
                else -> false
            }
        }
}}