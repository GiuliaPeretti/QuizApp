package com.example.quizapp.gamesData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert
    suspend fun insertGame(data: GamesData)

    @Delete
    suspend fun deleteGame(data: GamesData)

    @Query("SELECT * FROM GamesData WHERE topic=:topic")
    fun getGames(topic: String):List<GamesData>
}