package com.example.quizapp

import androidx.lifecycle.ViewModel
import java.io.File



class QuizViewModel: ViewModel() {
    fun getQuestion(){
        val filePath = "data.json" // Replace with your JSON file path
        val file = File(filePath)

        val jsonString = file.readText()
    }

}