package com.example.quizapp

import android.content.Context

sealed class QuizAction {
    data class Prova(val conetxt: Context): QuizAction()

}