package com.project.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.project.myapplication.R
import com.project.myapplication.databinding.FragmentDogDetailBinding



class DogDetailFragment : Fragment() {
    private lateinit var binding: FragmentDogDetailBinding

    private val args: DogDetailFragmentArgs by navArgs()
    // DogDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDogDetailBinding.inflate(layoutInflater)

        val text = "${args.name} is ${args.age} years old!"
        binding.viewDogDetail.text=text

       return binding.root

    }
}