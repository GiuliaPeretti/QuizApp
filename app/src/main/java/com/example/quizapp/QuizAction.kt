package com.example.quizapp

import android.content.Context
import androidx.navigation.NavHostController

sealed class QuizAction {
    data class Selected(val topic: String, val context: Context, val navController: NavHostController): QuizAction()
    object GetQuestion: QuizAction()
}