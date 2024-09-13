package com.example.aryana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.aryana.Adapters.FragmentPageAdapter
import com.example.aryana.Fragments.CartFragment
import com.example.aryana.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.home_bottom

        viewPager2 = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)


        //Initialize adapter
        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("Most Popular"))
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"))
        tabLayout.addTab(tabLayout.newTab().setText("Bakery"))
        tabLayout.addTab(tabLayout.newTab().setText("Cake"))
        tabLayout.addTab(tabLayout.newTab().setText("Italian"))

        viewPager2.adapter = adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_bottom -> true
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
