package com.example.quizapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface GamesDao {
    @Insert
    suspend fun insertGame(data: GamesData)

    @Delete
    suspend fun deleteGame(data: GamesData)

    @Query("SELECT * FROM gamesdata ORDER BY date")
    fun getGames(): List<GamesData>
}