package com.example.quizapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class GamesData(
    val topic: String,
    val score: Int,
    val date: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
