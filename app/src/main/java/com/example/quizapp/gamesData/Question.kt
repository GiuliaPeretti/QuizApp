package com.example.quizapp.gamesData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question (
    val topic: String,
    val question: String,
    val answers: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)