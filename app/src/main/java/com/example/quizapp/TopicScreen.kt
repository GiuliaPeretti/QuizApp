package com.example.quizapp

import android.adservices.topics.Topic
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme
import com.example.quizapp.ui.theme.ThemeColors
import java.io.File


import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.database.Cursor
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.TextClock
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*
import coil.compose.rememberImagePainter






@Composable
fun TopicScreen(
    navController: NavHostController,
    viewModel: QuizViewModel,
    context: Context,
    onAction: (QuizAction) -> Unit,
    topicList: List<List<String>>
){

    val l = listOf("Topic0","Topic1","Topic2","Topic3","Topic4","Topic5","Topic6","Topic7","Topic8","Topic9","Topic10")
    val d = listOf("Description0","Description1","Description2","Description3","Description4","Description5","Description6","Description7","Description8","Description9","Description10")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(bottom = 70.dp, top = 15.dp)
            .background(Theme().background)
    ){
        val titles=topicList[0]
        val descriptions=topicList[1]
        for (i in titles.indices) {
            Topic(
                title = titles[i],
                description = descriptions[i],
                onClick = {
                    onAction(QuizAction.SelectTopic(topic = titles[i], description = descriptions[i]))
                    navController.navigate("topicSelected")
                },
                viewModel = viewModel,
                topic = titles[i]
            )
        }
    }
    NavigationBar(navController = navController)
}




@SuppressLint("DiscouragedApi")
@Composable
fun Topic(
    title: String,
    description: String,
    onClick: () -> Unit,
    viewModel: QuizViewModel,
    topic: String
){
    //TODO: add shadow
    val l = listOf("Topic0","Topic1","Topic2","Topic3")
    val d = listOf("Description0","Description1","Description2","Description3")
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Theme().background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme().secondary)
                .height(100.dp)
        ) {


            val context = LocalContext.current
            val resourceId = context.resources.getIdentifier(topic.lowercase(), "drawable",
                context.packageName
            )

            val painter = if (resourceId != 0){
                painterResource(id = resourceId)

            } else {
                painterResource(id = R.drawable.not_found)
            }

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15.dp))
                )


//
//            Image(
//
//                painter = painter, contentDescription = null,
////            Image(painter = viewModel.getImage(), contentDescription = null,
//                modifier = Modifier
//                    .padding(5.dp)
//                    .clip(RoundedCornerShape(15.dp))
//            )


//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(<file_path>)
//                .build(),
//            contentDescription = "icon",
//            contentScale = ContentScale.Inside,
//            modifier = Modifier.size(30.dp)
//            )
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


fun Modifier.shadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)













