package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.ui.theme.Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun TopicSelectedScreen() {
    Column(
        modifier = Modifier
            .background(Theme().background)
            .fillMaxSize(),
    ) {
        Column (
            modifier = Modifier
                .background(color = Color.Green),
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            ) {
                Text(text = "Start")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Go back")
            }
        }
    }
}