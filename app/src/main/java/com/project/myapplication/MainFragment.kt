package com.project.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.project.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainBinding.inflate(layoutInflater)

        binding.apply {

            viewBtnDog.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_dogFragment)
            }

            viewBtnCat.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_catFragment)
            }
        }
        return binding.root
    }
}