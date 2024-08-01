package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme
import kotlin.reflect.KFunction1


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
                .padding(start = 20.dp, end = 20.dp)
        ){
                Button(
                onClick = { onAction(QuizAction.StartGame(context = context, navController = navController)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)


            ) {
                Text(text = "Start")
            }
            Button(
                onClick = { navController.navigate("topic") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)

            ) {
                Text(text = "Go back")
            }
        }
    }

    Column (
        modifier = Modifier
            .padding(top = 150.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = viewModel.getTopic(),
            fontSize = 50.sp,
            modifier = Modifier
        )
        Text(
            text = viewModel.getDescription(),
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 15.dp)
        )
    }
    NavigationBar(navController = navController)
}