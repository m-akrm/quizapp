package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentHomeScreenBinding


class HomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentHomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_home_screen,container,false)
        binding.startbutton.setOnClickListener {
            this.findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToQuizSelectionFragment())
        }
        return binding.root

    }

}