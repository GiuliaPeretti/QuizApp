package com.example.quizapp

import com.example.quizapp.gamesData.GamesData

data class QuizState(
    var topicList: List<String> = listOf(),
    var question2List: List<Question2> = listOf(),
    var topic: String = "",
    var description: String = "",
    var questionCount: Int = 0,
    var questionForGame: Int = 10,
    var answerSelected: Int = -1,
    val correctAnswers: Int = 0,
    val gamesRecords: List<GamesData> = listOf()
    /*TODO: se una categoria ha meno di 10 domande ci sono dei
        problemi perchè question count va dopo la lunghezza di currentquestions*/
    //var context: Context =
    //TODO: aggiungi context qua
)
