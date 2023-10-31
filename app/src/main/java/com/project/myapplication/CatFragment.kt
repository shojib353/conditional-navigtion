package com.project.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.project.myapplication.databinding.FragmentCatBinding


class CatFragment : Fragment(R.layout.fragment_cat) {
    lateinit var binding: FragmentCatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCatBinding.inflate(layoutInflater)
        binding.apply {
            viewCatSubmit.setOnClickListener { v ->
                val name = viewInputCatName.text.toString()
                val age = viewInputCatAge.text.toString().toInt()
                val bundle = bundleOf("name" to name, "age" to age)
                v.findNavController().navigate(R.id.action_catFragment_to_catDetailFragment, bundle)
            }
        }
        return binding.root
    }
}