package com.example.quizapp.gamesData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert
    suspend fun insertGame(data: GamesData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopic(topic: Topic)

    @Insert
    suspend fun insertQuestion(question: Question)

    @Delete
    suspend fun deleteGame(data: GamesData)

    @Query("SELECT * FROM GamesData WHERE topic=:topic")
    fun getGames(topic: String):List<GamesData>
}