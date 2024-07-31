package com.example.quizapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.io.StringReader
import java.security.AccessController.getContext


class QuizViewModel: ViewModel() {

    private val _state = MutableStateFlow(QuizState())
    val state: StateFlow<QuizState> = _state.asStateFlow()

    fun onAction(action: QuizAction){
        when(action){
            is QuizAction.Selected -> startGame(topic = action.topic, context = action.context)
        }
    }

    private fun startGame(topic: String, context: Context) {
        val questionsList=getQuestions(context = context)
        var currentQuestions: MutableList<Question> = mutableListOf()
        for (i in questionsList){
            //tieni solo se topic giusto
        }



        _state.value = _state.value.copy(
            currentQuestions = questionsList
        )

    }
    private fun getQuestions(context: Context): List<Question> {
        val jsonString = readCsvFromAssets(context, "questions.csv").toString()
        //TODO: gestisci eccezione
        var list = jsonString.split('\n')
        val questionsList: MutableList<Question> = mutableListOf()
        var l: List<String> = listOf()
        for (i in list){
            l = i.split(',')
            questionsList.add(Question(topic = l[0], question =  l[1], rightAnswer =  l[2], ans =  l[3]))
            Log.d("question",questionsList.last().toString())
        }
        return questionsList.toList()
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