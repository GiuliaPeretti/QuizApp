package com.example.quizapp.gamesData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GamesData(
    val topic: String,
    val score: Int,
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
