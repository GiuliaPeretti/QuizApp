package com.example.quizapp

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Upsert

interface GamesDao {
    @Insert
    suspend fun insertGame(data: GamesData)

    @Delete
    suspend fun deleteGame(data: GamesData)


}