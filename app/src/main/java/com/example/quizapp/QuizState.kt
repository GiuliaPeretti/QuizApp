package com.example.quizapp

import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class QuizState(
    var topicList: List<String> = listOf(),
    var currentQuestions: List<Question> = listOf(),
    var currentTopic: String = "",
    var questionCount: Int = 0,
    var questionForGame: Int = 10,
    var answerSelected: Int = -1,
    val correctAnswers: Int = 0
    /*TODO: se una categoria ha meno di 10 domande ci sono dei
        problemi perchè question count va dopo la lunghezza di currentquestions*/
    //var context: Context =
    //TODO: aggiungi context qua
)
