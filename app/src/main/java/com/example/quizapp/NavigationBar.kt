package com.example.quizapp

import androidx.annotation.NavigationRes
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.Theme

@Preview
@Composable
fun NavigationBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme().primary),
        verticalAlignment = Alignment.Bottom
        ){

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {

        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {

        }

    }
}