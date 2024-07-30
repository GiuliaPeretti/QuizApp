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
            is QuizAction.Selected -> startGame(topic = action.topic)
        }
    }

    private fun startGame(topic: String) {

    }
    private fun getQuestions(context: Context){
        val jsonString = readCsvFromAssets(context, "questions.csv").toString()
        //TODO: gestisci eccezione
        var list = jsonString.split('\n')
        val questionsList: MutableList<Question> = mutableListOf()
        val l: MutableList<String> = mutableListOf()
        for (i in questionsList){
            l=i.split(',')
            questionsList.add
        }
        //TODO: finisci qua
    }

    fun getTopics(context: Context): List<List<String>> {
        val jsonString = readCsvFromAssets(context, "topics.csv").toString()
        //TODO: togli il toString e controlla eccezione
        val topics = jsonString.split('\n')
        val titlesList: MutableList<String> = mutableListOf()
        val descriptionsList: MutableList<String> = mutableListOf()
        var l: List<String>
        for (i in topics){
            l=i.split(',')
            titlesList.add(l[0])
            descriptionsList.add(l[1])
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