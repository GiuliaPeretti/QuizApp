package com.example.quizapp

import androidx.annotation.NavigationRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme

@Composable
fun NavigationBar(
    navController: NavHostController

){
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp)
                .background(Theme().primary),
            verticalAlignment = Alignment.Bottom
        ) {

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
                Image(painter = painterResource(id = R.drawable.home), contentDescription = null)
            }
            Button(
                onClick = { navController.navigate("topic") },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
                Image(painter = painterResource(id = R.drawable.list), contentDescription = null)

            }
            Button(
                onClick = { /*TODO*/},
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)
            ) {
                Image(painter = painterResource(id = R.drawable.stats), contentDescription = null)

            }

        }
    }
}