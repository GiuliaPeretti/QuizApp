package com.example.quizapp.gamesData

import androidx.room.Database
import androidx.room.RoomDatabase

class TopicDatabase {

    @Database(
        entities = [GamesData::class, Topic::class, Question::class],
        version = 1
    )

    abstract class TopicDatabase: RoomDatabase(){
        abstract val dao: DatabaseDao
    }

}