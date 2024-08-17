package com.example.quizapp

sealed class GamesDataEvent {
    data class AddGame(val topic: String, val score: Int, val date: String): GamesDataEvent()
    data object DeleteRecords: GamesDataEvent()
    data class getGames(val topic: String): GamesDataEvent()
}