package com.example.quizapp

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Theme

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)

    @Composable
    fun QuestionScreen(
    ){
        Column (modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize(),

            verticalArrangement = Arrangement.Center
            //.background(Android_calculatorTheme().background)
            //.align(Alignment.Center)
        ){
            Row() {
                Text(
                    text = "Which is the capital of England?",
                    fontSize = 30.sp
                )
            }
            Column(modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
            ) {
                for (i in 0 until 4) {
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(70.dp)
                            .fillMaxWidth(),
                        onClick = {/* TODO */ }) {
                        Text(text = "Risposta$i")
                    }
                }
            }

        }
        Row(
            modifier = Modifier
                .align(Alignment.Bottom)
                .background(Theme().background)
                .fillMaxWidth(),
        ){

        }

    }