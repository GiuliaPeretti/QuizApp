package com.example.quizapp

sealed class GamesDataEvent {
    data object AddGame: GamesDataEvent()
    data object deleteRecords: GamesDataEvent()
}