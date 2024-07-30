package com.example.quizapp

import android.util.Log
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import java.io.File



class QuizViewModel: ViewModel() {
    fun onAction(action: QuizAction){
        when(action){
            is QuizAction.prova -> getQuestion()
        }
    }



    fun getQuestion(){
        val filePath = "QuestionList.json"
        val file = File(filePath)

        val jsonString = file.readText()
        val jsonOBj = JSONObject(jsonString)
        val list = jsonOBj.getString("Questions")
        Log.d("deb", list.toString())
    }

}