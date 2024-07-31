package com.example.quizapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
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
            is QuizAction.Selected -> startGame(topic = action.topic, context = action.context, navController = action.navController)
        }
    }

    fun getString(str: String): String{
        return when(str){
            "Question" -> _state.value.currentQuestions[_state.value.questionCount].question
            else -> "" //TODO: metti null, return type String? e poi gestisci l'eccezione
        }
    }

    private fun startGame(topic: String, context: Context,navController: NavHostController) {
        val questionsList=getQuestions(context = context)
        var currentQuestions: MutableList<Question> = mutableListOf()
        for (i in questionsList){
            if(i.topic==topic){
                currentQuestions.add(i)
            }
        }
        //disordino cosi poi le prendo in ordine e due partite dello stesso topic sono comunque diverse
        currentQuestions.shuffle()
        _state.value = _state.value.copy(
            currentQuestions = currentQuestions
        )
        for (i in currentQuestions){
            Log.d("debQuestion", i.question)
        }

        //displayQuestion(navController = navController)
        navController.navigate("question")
    }

//    fun getQuestion(){
//        //navController.navigate("question")
//    }

    fun getQuesiton(): String {
        return (_state.value.currentQuestions[_state.value.questionCount].question)
    }

    fun getAnswers(): List<String> {
        return (_state.value.currentQuestions[_state.value.questionCount].answers)
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