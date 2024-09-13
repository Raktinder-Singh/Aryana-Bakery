package com.example.aryana.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aryana.Adapters.cartAdapter
import com.example.aryana.R
import com.example.aryana.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var cartFoodName: ArrayList<String>
    private lateinit var cartItemPrice: ArrayList<String>
    private lateinit var cartImage: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            cartFoodName = it.getStringArrayList("cart_items") ?: arrayListOf()
            cartItemPrice = it.getStringArrayList("cart_item_prices") ?: arrayListOf()
            cartImage = it.getIntegerArrayList("cart_images") ?: arrayListOf()
        }

        val adapter = cartAdapter(cartFoodName, cartItemPrice, cartImage)
        binding.RecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.RecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(cartItems: ArrayList<String>, cartItemPrices: ArrayList<String>, cartImages: ArrayList<Int>): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            args.putStringArrayList("cart_items", cartItems)
            args.putStringArrayList("cart_item_prices", cartItemPrices)
            args.putIntegerArrayList("cart_images", cartImages)
            fragment.arguments = args
            return fragment
        }
    }
}
