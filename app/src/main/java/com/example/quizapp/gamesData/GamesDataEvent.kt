package com.example.quizapp.gamesData

sealed class GamesDataEvent {
    data class AddGame(val topic: String, val score: Int, val date: String): GamesDataEvent()
    data object DeleteRecords: GamesDataEvent()
    data class GetGames(val topic: String): GamesDataEvent()
}