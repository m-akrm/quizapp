package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        binding.question=sharedViewModel.chooseRandomQuestion()
        sharedViewModel.questionNumber+=1
        binding.questionnumber.text=sharedViewModel.questionNumber.toString()
        binding.optionAcardview.setOnClickListener{
            sharedViewModel.checkAnswer('A')
            if (sharedViewModel.questionNumber==3){
                this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToScoreFragment(sharedViewModel.score))
            }
            else{
                this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentSelf())
            }
        }
        binding.optionBcardview.setOnClickListener {
            sharedViewModel.checkAnswer('B')
            if (sharedViewModel.questionNumber == 3) {
                this.findNavController()
                    .navigate(QuizFragmentDirections.actionQuizFragmentToScoreFragment(sharedViewModel.score))
            } else {
                this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentSelf())
            }
        }
        binding.optionCcardview.setOnClickListener {
            sharedViewModel.checkAnswer('C')
            if (sharedViewModel.questionNumber == 3) {
                this.findNavController()
                    .navigate(QuizFragmentDirections.actionQuizFragmentToScoreFragment(sharedViewModel.score))
            } else {
                this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentSelf())
            }
        }
        binding.optionDcardview.setOnClickListener {
            sharedViewModel.checkAnswer('D')
            if (sharedViewModel.questionNumber == 3) {
                this.findNavController()
                    .navigate(QuizFragmentDirections.actionQuizFragmentToScoreFragment(sharedViewModel.score))
            } else {
                this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentSelf())
            }
        }

        return binding.root

    }


}