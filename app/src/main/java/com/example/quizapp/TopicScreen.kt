package com.example.quizapp

import android.adservices.topics.Topic
import android.content.Context
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
import androidx.navigation.NavHostController
import com.example.quizapp.ui.theme.Theme
import com.example.quizapp.ui.theme.ThemeColors


@Composable
fun TopicScreen(
    navController: NavHostController,
    viewModel: QuizViewModel,
    context: Context,
    topicList: List<List<String>>
){

    val l = listOf("Topic0","Topic1","Topic2","Topic3","Topic4","Topic5","Topic6","Topic7","Topic8","Topic9","Topic10")
    val d = listOf("Description0","Description1","Description2","Description3","Description4","Description5","Description6","Description7","Description8","Description9","Description10")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(bottom = 70.dp)
            .background(Theme().background)
    ){
        val titles=topicList[0]
        val descriptions=topicList[1]
        for (i in titles.indices) {
            Topic(title = titles[i], description = descriptions[i], onAction = viewModel::onAction, context = context)
        }
    }
    NavigationBar(navController = navController)
}




@Composable
fun Topic(
    title: String,
    description: String,
    onAction: (QuizAction) -> Unit,
    context: Context
){
    //TODO: add shadow
    val l = listOf("Topic0","Topic1","Topic2","Topic3")
    val d = listOf("Description0","Description1","Description2","Description3")
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Theme().background)
            .clickable(onClick = { onAction(QuizAction.Prova(conetxt = context)) })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme().secondary)
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













