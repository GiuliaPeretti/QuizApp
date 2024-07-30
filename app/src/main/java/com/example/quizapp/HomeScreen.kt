package com.example.quizapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center
        ){
        Button(
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp)
                .fillMaxWidth(),
            onClick = {/* TODO: quest */ }) {
            Text(text = "Start")
        }
        Button(
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp)
                .fillMaxWidth(),
            onClick = {/* TODO: quest */ }) {
            Text(text = "Settings")
        }

    }
    NavigationBar(navController = navController)
}