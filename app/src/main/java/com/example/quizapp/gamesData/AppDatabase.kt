package com.example.quizapp.gamesData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        Topic::class,
        GamesData::class,
        Question::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val DatabaseDao: DatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): Any {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "games_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }


    }
}


