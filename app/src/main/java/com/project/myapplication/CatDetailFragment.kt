package com.project.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.myapplication.databinding.FragmentCatDetailBinding


class CatDetailFragment : Fragment() {

    private lateinit var binding: FragmentCatDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCatDetailBinding.inflate(layoutInflater)
        val name = arguments?.getString("name")
        val age = arguments?.getInt("age")
        val text = "$name is $age years old!"
        binding.apply {
        viewCatDetail.text = text }
        return binding.root
    }
}