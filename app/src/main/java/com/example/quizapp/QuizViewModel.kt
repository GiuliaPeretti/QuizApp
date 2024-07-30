package com.example.quizapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.io.StringReader
import java.security.AccessController.getContext


class QuizViewModel: ViewModel() {
    fun onAction(action: QuizAction){
        when(action){
            is QuizAction.Prova -> getQuestion(context = action.conetxt)
        }
    }



    fun getQuestion(context: Context){
        val csvString = readCsvFromAssets(context, "your_file.csv")
        Log.d("deb", csvString.toString())
//        if (csvString != null) {
//            val lines = csvString.split("\n")
//            for (line in lines) {
//                val values = line.split(",") // Use appropriate separator
//                for (value in values) {
//                    // Processeach value (string)
//                }
//            }
//        }
    }

    fun readCsvFromAssets(context: Context, fileName: String): String? {return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        null
    }
    }

}