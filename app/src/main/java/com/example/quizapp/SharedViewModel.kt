package com.example.quizapp

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var questionNumber = 0
    private val geoQuestions = listOf(
        Question("What is the largest desert in the world?", 'B', "Sahara Desert", "Antarctic Desert", "Arabian Desert", "Gobi Desert"),
        Question("Which river is the longest in the world?", 'A', "Nile River", "Amazon River", "Yangtze River", "Mississippi River"),
        Question("Which country has the most natural lakes?", 'C', "United States", "Russia", "Canada", "India"),
        Question("What is the capital city of Australia?", 'D', "Sydney", "Melbourne", "Brisbane", "Canberra"),
        Question("Which mountain is the tallest in the world?", 'A', "Mount Everest", "K2", "Kangchenjunga", "Lhotse"),
    )
    private val astroQuestions = listOf(
        Question("Which planet is known as the Red Planet?", 'B', "Venus", "Mars", "Jupiter", "Saturn"),
        Question("What is the largest planet in our solar system?", 'C', "Earth", "Saturn", "Jupiter", "Neptune"),
        Question("What is the name of the galaxy we live in?", 'A', "Milky Way", "Andromeda", "Whirlpool", "Sombrero"),
        Question("Which planet has the most moons?", 'D', "Earth", "Mars", "Neptune", "Jupiter"),
        Question("What is the closest star to Earth?", 'B', "Sirius", "Proxima Centauri", "Alpha Centauri", "Barnard's Star")
    )
    private lateinit var quiz : List<Question>
    private lateinit var question: Question
    var availablQuestion = mutableListOf<Int>(0,1,2,3,4)
    var score=0
    private fun quizInit(){
        score=0
        questionNumber=0
        availablQuestion = mutableListOf<Int>(0,1,2,3,4)
    }

    private fun chooseRandomQuiz(){
        val random = (0..1).random()
        if (random == 0) {
            quiz = geoQuestions
        } else {
            quiz = astroQuestions
        }
    }
    fun chooseQuizAndInit(quiz: Quiz){
        quizInit()
        if (quiz.name =="Geography"){
            this.quiz = geoQuestions

        }
        else if (quiz.name =="Astronomy") {
            this.quiz = astroQuestions
        }
        else{
            chooseRandomQuiz()
        }
    }
    fun chooseRandomQuestion(): Question {
        val random = availablQuestion.random()
        availablQuestion.remove(random)

        question=quiz[random]
        return question
    }

    fun checkAnswer(answer: Char) {
        if(answer==question.answer)score++
    }
}