package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {
    val args:ScoreFragmentArgs by navArgs()
    private lateinit var binding: FragmentScoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentScoreBinding.inflate(inflater,container,false)
        binding.scoretext.text=args.score.toString()
        if(args.score==3){
            binding.resulttext.text="You Won"

        }
        binding.button.setOnClickListener {
            this.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToHomeScreenFragment())
        }

        return binding.root
    }


}