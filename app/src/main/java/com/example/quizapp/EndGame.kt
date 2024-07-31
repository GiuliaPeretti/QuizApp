package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import com.example.quizapp.ui.theme.Theme
import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.layers.line

@Preview
@Composable

fun EndGame(){
    Column (
        modifier = Modifier
            .background(Theme().background)
            .fillMaxSize(),
    ){

        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
                .background(Theme().secondary),
        ) {
            Text(
                text = "Score:",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(Alignment.CenterHorizontally),

                )
            Text(
                text = "8/10",
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 3.dp)
                    .align(Alignment.CenterHorizontally),

                )
        }




    }
}

//@Composable
//fun LineChart(){
//    val xAxisData = AxisData.Builder()
//        .axisStepSize(100.dp)
//        .backgroundColor(Color.Transparent)
//        .steps(5)
//        .labelData { i -> i.toString() }
//        .labelAndAxisLinePadding(15.dp)
//        .axisLineColor(Color.Red)
//        .axisLabelColor(Color.Green)
//        .build()
//
//    val yAxisData = AxisData.Builder()
//        .axisStepSize(100.dp)
//        .backgroundColor(Color.Transparent)
//        .steps(10)
//        .labelData { i -> i.toString() }
//        .labelAndAxisLinePadding(15.dp)
//        .axisLineColor(Color.Red)
//        .axisLabelColor(Color.Green)
//        .build()
//
//    val     q
//}

