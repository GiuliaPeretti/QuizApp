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

    fun getTopics(context: Context): List<List<String>> {
        val jsonObj = getData(context)
        var topics = jsonObj.get("Topics").toString()
        val topicsString:MutableList<JSONObject> = mutableListOf()
        var s: String
        while('{' in topics){
            s = topics.substring(topics.indexOf('{'), topics.indexOf('}')+1)
            topicsString.add(JSONObject(s))
            topics=topics.substring(topics.indexOf('}')+1, topics.length)
        }
        val titlesList: MutableList<String> = mutableListOf()
        val descriptionsList: MutableList<String> = mutableListOf()
        var json: JSONObject
        for (i in topicsString){
            json= i
            titlesList.add(json.get("Title").toString())
            descriptionsList.add(json.get("Description").toString())
        }
        val topicList = listOf(titlesList.toList(), descriptionsList.toList())
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