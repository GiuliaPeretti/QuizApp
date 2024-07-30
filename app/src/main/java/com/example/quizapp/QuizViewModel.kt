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
            is QuizAction.Prova -> getTopics(context = action.conetxt)
        }
    }

    fun getTopics(context: Context): List<String> {
        val jsonObj = getData(context)
        val l = jsonObj.get("Topics").toString()
        val topicList = l.substring(1,l.length-1).split(',')
        Log.d("deb", topicList.toString())
        return topicList
    }

    fun getData(context: Context): JSONObject {
        val jsonString = readCsvFromAssets(context, "data.json")
        val jsonObj = JSONObject(jsonString.toString())
        return jsonObj
    }

    fun readCsvFromAssets(context: Context, fileName: String): String? {return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        null
    }
    }


}