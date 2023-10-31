package com.project.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.project.myapplication.R
import com.project.myapplication.databinding.FragmentDogBinding


class DogFragment : Fragment() {
    private lateinit var binding: FragmentDogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDogBinding.inflate(layoutInflater)
        binding.apply {

        viewDogSubmit.setOnClickListener { v ->
            val name = viewInputDogName.text.toString()
            val age = viewInputDogAge.text.toString().toInt()
            val bundle = bundleOf("name" to name, "age" to age)
           // val action = DogFragmentDirections.actionDogFragmentToDogDetailFragment(name, age)
            v.findNavController().navigate(R.id.action_dogFragment_to_dogDetailFragment, bundle)


        } }
        return binding.root
    }
}