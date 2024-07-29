package com.example.quizapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)

    @Composable
    fun HomeScreen(){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            //.background(Android_calculatorTheme().background)
            //.align(Alignment.Center)
        ){
            Text(text = "Which is the capital of England?",
                fontSize = 30.sp
            )
        }
        Box(modifier = Modifier
            .fillMaxHeight()
        ) {
            var p = 20
            for (i in 0 until 4) {
                p += 50
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = p.dp),

                    onClick = {/* TODO */ }) {
                    Text(text = "Risposta$i")
                }
            }
        }
    }