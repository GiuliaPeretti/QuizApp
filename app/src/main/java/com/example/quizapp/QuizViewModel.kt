package com.example.quizapp

import android.content.Context
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import co.yml.charts.common.model.Point
import com.example.quizapp.ui.theme.DarkColorScheme
import com.example.quizapp.ui.theme.LightColorScheme
import com.example.quizapp.ui.theme.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.io.StringReader
import java.security.AccessController.getContext


class QuizViewModel: ViewModel() {

    //TODO: fai diventare tutti i metodi privati
    //TODO: togli tutti i navcontroller dalle funzioni (mettili nel onclick)
    private val _state = MutableStateFlow(QuizState())
    val state: StateFlow<QuizState> = _state.asStateFlow()

    fun onAction(action: QuizAction){
        when(action){
            is QuizAction.StartGame -> startGame(context = action.context)
            is QuizAction.SelectTopic -> setTopic(topic = action.topic, description = action.description)
            is QuizAction.NewQuestion -> newQuestion(navController = action.navController)
        }
    }


    fun getAnswerSelected(): Int {
        return _state.value.answerSelected
    }

    fun getRightAnswer(): String {
        return _state.value.questionList[_state.value.questionCount].rightAnswer
    }

    fun getTopic(): String {
        return(_state.value.topic)
    }

    fun getDescription(): String{
        return _state.value.description
    }

    fun getQuesiton(): String {
        return (_state.value.questionList[_state.value.questionCount].question)
    }

    fun getAnswers(): List<String> {
        return (_state.value.questionList[_state.value.questionCount].answers)
    }

    fun getQuestionCounter(): Int{
        return (_state.value.questionCount)
    }

    fun getQuestionForGame(): Int{
        return (_state.value.questionForGame)
    }

    fun getCorrect(): Int{
        return _state.value.correctAnswers
    }

    fun getPoints(topic: String = _state.value.topic, context: Context): List<Point> {
        val gamesString = readCsvFromAssets(context, "games.csv").toString()
        val gamesList = gamesString.split('\n')
        val pointList: MutableList<Point> = mutableListOf()
        var l: List<String> = listOf()
        var count = 0
        for (i in gamesList){
            l = i.split(',')
            if (l[0]==topic){
                pointList.add(Point(x= count.toFloat(), y= l[1].toFloat()))
                count += 1
            }
        }
        if(pointList.isEmpty()){
            pointList.add(Point(0f,0f))
        }
        return pointList.toList()
    }


    fun getQuestions(context: Context): List<Question> {
        val questionsString: String = readCsvFromAssets(context, "questions.csv").toString()
        //TODO: gestisci eccezione
        var list = questionsString.split('\n')
        val questionsList: MutableList<Question> = mutableListOf()
        var l: List<String> = listOf()
        for (i in list){
            l = i.split(',')
            questionsList.add(Question(topic = l[0], question =  l[1], rightAnswer =  l[2], ans =  l[3]))
        }
        return questionsList.toList()
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






    private fun setTopic(topic: String, description: String) {
        _state.value = _state.value.copy(
            topic = topic
        )
        _state.value = _state.value.copy(
            description = description
        )
    }

    fun newQuestion(navController: NavHostController) {
        //TODO: fai che quando il conto è 10 fai altro
        if(getAnswerSelected()==-1){
            return
        }
        _state.value = _state.value.copy(
            questionCount = _state.value.questionCount+1
        )
        _state.value = _state.value.copy(
            answerSelected = -1
        )

        if (_state.value.questionCount==1){
            navController.navigate("endGame")
            return
        }

        navController.navigate("question")
    }


    fun startGame(context: Context) {
        val topic = getTopic()
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
            questionList = questionsList
        )
        _state.value = _state.value.copy(
            questionCount = 0
        )
        _state.value = _state.value.copy(
            correctAnswers = 0
        )


        //displayQuestion(navController = navController)
    }





//    fun getColorList(): List<Color> {
//        if (_state.value.answerSelected==-1){
//            return(listOf(getTheme().primary, getTheme().primary, getTheme().primary, getTheme().primary))
//        }
//    }
    //TODO: prova a mettere questio nella classe topicScreem
//
//    fun getTheme(): ColorScheme {
//        val colorScheme = if(isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
//        return colorScheme
//    }



    fun checkAnswer(navController: NavHostController, n: Int){
        //TODO: controllaa punteggio
        if (_state.value.answerSelected!=-1){
            return
        }
        if (getAnswers()[n]==getRightAnswer()){
            _state.value = _state.value.copy(
                correctAnswers = _state.value.correctAnswers+1
            )
        }
        _state.value = _state.value.copy(
            answerSelected = n
        )
        navController.navigate("question")

    }





    fun readCsvFromAssets(context: Context, fileName: String): String? {return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        null
    }
    }


    fun getImage(topic: String){

    }

    fun deleteStats() {
        File("games.csv").writeText("")
    }


}