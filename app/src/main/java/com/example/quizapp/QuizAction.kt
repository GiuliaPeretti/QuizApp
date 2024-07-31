package com.example.quizapp

import android.content.Context

sealed class QuizAction {
    data class Selected(val topic: String, val context: Context): QuizAction()

}