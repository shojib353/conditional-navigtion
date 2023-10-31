package com.project.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.project.myapplication.databinding.FragmentWelcomeBinding



class WelcomeFragment : Fragment(){

    private lateinit var mainActivity: MainActivity

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentWelcomeBinding.inflate(layoutInflater)

        mainActivity = requireActivity() as MainActivity
        binding.apply {

        viewBtnOk.setOnClickListener {
            mainActivity.hasCompletedWelcome = true
            // navigateToMain()
            mainActivity.restart()
        }}
        return binding.root
    }

    private fun navigateToMain() {
        findNavController().navigate(R.id.action_welcomeFragment_to_mainFragment)
    }
}