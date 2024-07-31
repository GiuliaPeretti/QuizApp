package com.example.quizapp

import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class QuizState(
    var topicList: List<String> = listOf(),
    var currentQuestions: List<Question> = listOf(),
    var questionCount: Int = 0
    //var context: Context =
    //TODO: aggiungi context qua
)
