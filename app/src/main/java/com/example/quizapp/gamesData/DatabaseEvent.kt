package com.example.quizapp.gamesData

sealed class DatabaseEvent {
    data class AddGame(val topic: String, val score: Int, val date: String): DatabaseEvent()
    data class InsertTopic(val topic: String, val description: String): DatabaseEvent()
    data class InsertQuestion(val topic: String, val question: String, val answers: String): DatabaseEvent()
    data object DeleteRecords: DatabaseEvent()
    data class GetGames(val topic: String): DatabaseEvent()
    data class GetTopics(val topic: String)
    data class GetQuestion(val topic: String)
}