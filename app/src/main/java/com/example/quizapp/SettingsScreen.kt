package com.example.quizapp

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Theme

@Preview
@Composable
fun SettingsScreen () {
    Column (
        modifier = Modifier
            .background(Theme().background)
            .fillMaxSize()
    ){
        for (i in 0 until 10){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 0.3.dp, color = Color.Gray)
            ){
                Text(
                    text = "Row$i",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp, bottom = 10.dp)
                )
            }
        }

    }
}