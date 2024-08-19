package com.example.quizapp.screens

import android.content.Context
import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme


import android.annotation.SuppressLint
import androidx.compose.ui.platform.LocalContext
import com.example.quizapp.QuizAction
import com.example.quizapp.QuizViewModel
import com.example.quizapp.R

//TODO: se stai facendo il quiz e vai su topic e poi vai sullo stesso topic il quiz riparte da dove era

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













