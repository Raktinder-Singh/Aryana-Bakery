package com.example.aryana.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.aryana.R
import com.example.aryana.databinding.FragmentMostPopularBinding


class MostPopularFragment : Fragment() {
    private lateinit var binding: FragmentMostPopularBinding
    private lateinit var nestedScrollView: NestedScrollView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMostPopularBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.americancoffee, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.donut, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.chococake, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        imageSlider.setItemClickListener(object: ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }

        } )
    }


}