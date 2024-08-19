package com.example.quizapp.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizapp.QuizAction
import com.example.quizapp.QuizViewModel
import com.example.quizapp.ui.theme.Theme


@Composable
fun TopicSelectedScreen(
    onAction: (QuizAction) -> Unit,
    viewModel: QuizViewModel,
    navController: NavHostController,
    context: Context = LocalContext.current
) {
    Column(
        modifier = Modifier
            .background(Theme().background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column (
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 100.dp)
        ){
            Column (
                modifier = Modifier
                    .padding(bottom = 30.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = viewModel.getTopic(),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    modifier = Modifier
                )
                Text(
                    text = viewModel.getDescription(),
                    textAlign = TextAlign.Center,
//                    text = "Questions about common knowledge",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(top = 15.dp)
                )
            }

                Button(
                onClick = {
                    onAction(QuizAction.StartGame(context = context))
                    navController.navigate("question")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .height(70.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)


            ) {
                Text(
                    text = "Start",
                    fontSize = 20.sp
                    )
            }
            Button(
                onClick = {
                    navController.navigate("topic")
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .height(70.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)

            ) {
                Text(
                    text = "Go back",
                    fontSize = 20.sp
                    )
            }
        }
    }


    NavigationBar(navController = navController)
}