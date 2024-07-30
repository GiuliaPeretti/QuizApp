package com.example.quizapp

import android.adservices.topics.Topic
import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Theme
import com.example.quizapp.ui.theme.ThemeColors

@Preview
@Composable
fun TopicScreen(){
    val l = listOf("Topic0","Topic1","Topic2","Topic3")
    val d = listOf("Description0","Description1","Description2","Description3")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Theme().background)
    ){
        for (i in l.indices) {
            Topic(title = l[i], description = d[i])
        }
    }
    NavigationBar()
}

@Composable
fun Topic(title: String, description: String){
    val l = listOf("Topic0","Topic1","Topic2","Topic3")
    val d = listOf("Description0","Description1","Description2","Description3")
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .shadow(elevation = 60.dp, ambientColor = Theme().primary)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme().tertiary)
                .height(100.dp)
        ) {
            Image(painter = painterResource(R.drawable.geography), contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))

            )
            Column(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                Text(text = title, fontSize = 30.sp)
                Text(text = description)
            }
        }
    }
}













