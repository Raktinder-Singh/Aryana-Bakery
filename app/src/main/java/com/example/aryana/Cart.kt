package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aryana.Fragments.CartFragment
import com.example.aryana.databinding.ActivityCartBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Cart : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.cart_bottom

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_bottom -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.cart_bottom -> true
                R.id.search -> {
                    val intent = Intent(this, order::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile_bottom -> {
                    val intent = Intent(this, profile::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Sample cart data
        val cartItems = arrayListOf("Cupcake", "Burger", "Chocolate Cake", "Donut", "Brownie", "Rum balls")
        val cartItemPrices = arrayListOf("Rs.20", "Rs.50", "Rs.320", "Rs.20", "Rs.40", "Rs.20")
        val cartImages = arrayListOf(
            R.drawable.minicupcake,
            R.drawable.burger,
            R.drawable.chococake,
            R.drawable.donut,
            R.drawable.brownie,
            R.drawable.rumballs
        )

        val cartFragment = CartFragment.newInstance(cartItems, cartItemPrices, cartImages)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, cartFragment)
            .commit()
    }
}
