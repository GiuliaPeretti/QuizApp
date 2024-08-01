package com.example.quizapp

import android.content.ClipDescription
import android.content.Context
import androidx.navigation.NavHostController

sealed class QuizAction {
    data class StartGame(val context: Context): QuizAction()
    data class NewQuestion(val navController: NavHostController): QuizAction()
    data class SelectTopic(val topic: String, val description: String): QuizAction()
}