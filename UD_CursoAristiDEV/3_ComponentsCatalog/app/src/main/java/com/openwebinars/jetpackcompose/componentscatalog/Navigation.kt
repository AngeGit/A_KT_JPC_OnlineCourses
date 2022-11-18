package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.openwebinars.jetpackcompose.componentscatalog.models.Routes.*

@Composable
fun NavigationExercises() {
    val navigationController = rememberNavController()
    //Esto es un poco como el grafo, donde se definen las keys o rutas y el composable que muestran
    NavHost(navController = navigationController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) { MyScreen1(navigationController) }
        composable(Pantalla2.route) { MyScreen2(navigationController) }
        composable(Pantalla3.route) { MyScreen3(navigationController) }
        composable(
            Pantalla4.route,
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("num") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            MyScreen4(
                navigationController,
                backStackEntry.arguments?.getString("name").orEmpty(),
                backStackEntry.arguments?.getInt("num") ?: 0
            )
        }
        composable(
            Pantalla5.route,
            arguments = listOf(
                navArgument("name") { defaultValue = "Dracarys!" }
            )
        ) { backStackEntry ->
            MyScreen5(
                navigationController,
                backStackEntry.arguments?.getString("name").orEmpty()
            )
        }
    }
}


@Composable
fun MyScreen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla2.route) })
    }
}

@Composable
fun MyScreen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla3.route) })
    }
}

@Composable
fun MyScreen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Pantalla 3", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationController.navigate(
                    Pantalla4.createRoute4(
                        "Rhaenyra",
                        37
                    )
                )
            })
    }
}

@Composable
fun MyScreen4(navigationController: NavHostController, name: String, num: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Hi $name,$num", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navigationController.navigate(Pantalla5.createRoute5("Long live the black Queen!")) }) //navigationController.navigate(Pantalla5.route)
    }
}

@Composable
fun MyScreen5(navigationController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = name, modifier = Modifier
            .align(Alignment.Center)
            .clickable { navigationController.navigate(Pantalla1.route) })
    }
}