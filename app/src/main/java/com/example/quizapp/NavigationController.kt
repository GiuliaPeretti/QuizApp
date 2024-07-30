package com.example.quizapp

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationController(){
    val navController = rememberNavController()
    val viewModel = QuizViewModel()
    NavHost(navController = navController, startDestination = "home") {
        composable(
            route="home",
            enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            exitTransition = { fadeOut(animationSpec = spring(stiffness = Spring.StiffnessHigh)) }
        ) { HomeScreen(navController = navController) }
        composable(
            route="topic",
            enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            exitTransition = { fadeOut(animationSpec = spring(stiffness = Spring.StiffnessHigh)) }
        ) { TopicScreen(
            navController = navController,
            viewModel = viewModel,
            ) }
        composable(
            route="question",
            enterTransition = { fadeIn(animationSpec = spring(stiffness = Spring.StiffnessHigh)) },
            exitTransition = { fadeOut(animationSpec = spring(stiffness = Spring.StiffnessHigh)) }
        ) { QuestionScreen(navController = navController) }
    }
}