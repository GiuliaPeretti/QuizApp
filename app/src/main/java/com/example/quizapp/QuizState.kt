package com.example.quizapp

import android.content.Context

data class QuizState(
    var topicList: List<String> = listOf(),
    var currentQuestions: List<Question> = listOf()
    //var context: Context =
    //TODO: aggiungi context qua
)
