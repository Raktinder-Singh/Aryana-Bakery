package com.example.aryana.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aryana.Fragments.CartFragment
import com.example.aryana.Fragments.FavouriteFragment
import com.example.aryana.Fragments.HomeFragment
import com.example.aryana.Fragments.MostPopularFragment
import com.example.aryana.Fragments.OrderFragment
import com.example.aryana.Fragments.ProfileFragment

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MostPopularFragment()
            1 -> HomeFragment()
            2 -> FavouriteFragment()
            3 -> OrderFragment()
            4 -> ProfileFragment()

            else -> MostPopularFragment()
        }
    }
}