package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "preview myScreen",
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5
)
@Composable
fun MainScreen() {
    // A surface container using the 'background' color from the theme
    Surface(
     //   modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
       // ComponentExercisesScreen()
        NavigationExercises()
    }


}