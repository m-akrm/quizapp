package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentQuizSelectionBinding


class QuizSelectionFragment : Fragment() {

    private lateinit var binding: FragmentQuizSelectionBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizSelectionBinding.inflate(inflater, container, false)
        val adapter= Adapter(
            clickListener = {
                sharedViewModel.chooseQuizAndInit(it)
                this.findNavController().navigate(QuizSelectionFragmentDirections.actionQuizSelectionFragmentToQuizFragment())
            }
        )
        val list= listOf(
            Quiz("Astronomy",R.drawable.astronomy),
            Quiz("Geography",R.drawable.geography),
            Quiz("Random",R.drawable.random)
        )
        adapter.submitList(list)
        binding.recyclerview.adapter=adapter

        return binding.root

    }


}