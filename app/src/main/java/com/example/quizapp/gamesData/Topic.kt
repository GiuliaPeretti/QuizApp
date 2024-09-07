package com.example.quizapp.gamesData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic (
     val description: String,
     @PrimaryKey(autoGenerate = false)
     val topic: String
)