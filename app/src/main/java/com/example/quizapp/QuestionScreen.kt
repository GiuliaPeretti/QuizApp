package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.reflect.KFunction1

@OptIn(ExperimentalLayoutApi::class)

@Composable
fun QuestionScreen(
    navController: NavHostController,
    onAction: (QuizAction) -> Unit,
    viewModel: QuizViewModel,
){
    NavigationBar(navController = navController)
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row() {
            Text(
                text = viewModel.getQuesiton(),
                fontSize = 30.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
        ) {
            val l =viewModel.getAnswers()
            val colorList: MutableList<Color>
            if(viewModel.getAnswerSelected()==-1) {
                colorList = mutableListOf(Theme().primary, Theme().primary, Theme().primary, Theme().primary)
            } else{
                val n=viewModel.getAnswerSelected()
                val ans =viewModel.getRightAnswer()
                if (l[n]==ans){
                    colorList = mutableListOf(Theme().primary, Theme().primary, Theme().primary, Theme().primary)
                    colorList[n]=Color.Green
                } else {
                    colorList = mutableListOf(Theme().primary, Theme().primary, Theme().primary, Theme().primary)
                    colorList[n]=Color.Red
                    colorList[l.indexOf(ans)]=Color.Green
                }
            }
            for (i in l.indices) {
                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(70.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorList[i], // Set the desired background color
                        contentColor = Color.White  // Set the desired text color
                    ),
                    //onClick = {onAction(QuizAction.NewQuestion(navController = navController))}) {

                    //onClick = {viewModel.checkAnswer(navController = navController, n = i)}) {
                    onClick = {viewModel.checkAnswer(navController = navController, n = i)}) {


                    Text(
                        text = l[i],
                        fontSize = 20.sp
                    )
                }
            }
        }


        Row {
            val colorNext: Color
            if(viewModel.getAnswerSelected()==-1){
                colorNext = Theme().secondary
            } else {
                colorNext = Theme().primary
            }
            Button(
                onClick = {onAction(QuizAction.NewQuestion(navController = navController))},
                modifier = Modifier
                    .height(110.dp)
                    .width(200.dp)
                    .padding(vertical = 30.dp, horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorNext, // Set the desired background color
                    contentColor = Color.White  // Set the desired text color
                ),
            ) {
                Text(
                    text = "Next",
                    fontSize = 20.sp
                )
            }
        }


    }
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = (viewModel.getQuestionCounter()+1).toString()+'/'+viewModel.getQuestionForGame(),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .align(Alignment.Top),
            fontSize = 30.sp,
        )
    }



}


