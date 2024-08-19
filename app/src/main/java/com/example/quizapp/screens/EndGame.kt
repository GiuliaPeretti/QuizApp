package com.example.quizapp.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.AccessibilityConfig
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.quizapp.QuizAction
import com.example.quizapp.QuizViewModel
import com.example.quizapp.ui.theme.Theme

@Composable
fun EndGame(
    viewModel: QuizViewModel,
    context: Context,
    onAction: (QuizAction) -> Unit,
    navController: NavHostController
){

    //score square
    Column (
        modifier = Modifier
            .background(Theme().background)
            .fillMaxSize(),
    ) {

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
                text = viewModel.getCorrect().toString()+"/10",
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 3.dp)
                    .align(Alignment.CenterHorizontally),

                )
        }
    }


        //chart
        Column(
            modifier = Modifier
                .padding(bottom = 100.dp, start = 10.dp, end = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LineChart(pointsData = viewModel.getPoints(t= null,context = context))
//            LineChart(pointsData = listOf(Point(0f, 5f),Point(1f, 8f),Point(2f, 3f),Point(3f, 5f)))

        }


        //two buttons
        Column (
            modifier = Modifier
                .padding(vertical = 120.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { onAction(QuizAction.StartGame(context = context)) },
                modifier = Modifier
                    .padding(5.dp)
                    .height(50.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)

            ) {
                Text(
                    text = "Restart",
                    fontSize = 20.sp
                    )
            }
            Button(
                onClick = { navController.navigate("stats") },
                modifier = Modifier
                    .padding(5.dp)
                    .height(50.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Theme().primary)

            ) {
                Text(
                    text = "Stats",
                    fontSize = 20.sp
                )
            }
        }




    //navigationBar
    NavigationBar(navController = navController)

}





data class LineChartData(
    val linePlotData: LinePlotData,
    val xAxisData: AxisData = AxisData.Builder().build(),
    val yAxisData: AxisData = AxisData.Builder().build(),
    val isZoomAllowed: Boolean = true,
    val paddingTop: Dp = 30.dp,
    val bottomPadding: Dp = 10.dp,
    val paddingRight: Dp = 10.dp,
    val containerPaddingEnd: Dp = 15.dp,
    val backgroundColor: Color = Color.White,
    val gridLines: GridLines? = null,
    val accessibilityConfig: AccessibilityConfig = AccessibilityConfig()
)

@Composable
fun LineChart(pointsData: List<Point>){
    val xAxisData = AxisData
        .Builder()
        .axisStepSize(50.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(10.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .axisStepSize(50.dp)
        .steps(10)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(10.dp)
        .labelData { i ->
            val yScale = 1
            (i*yScale).toString()
        }.build()



    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(lineType = LineType.Straight()),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )


    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        lineChartData = lineChartData
    )
}

//TODO: quando finisce il gioco aggiorna i dati