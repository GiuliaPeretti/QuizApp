package com.example.quizapp.gamesData

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [GamesData::class],
    version = 1
)

abstract class GamesDatabase: RoomDatabase(){
    abstract val dao: DatabaseDao
}