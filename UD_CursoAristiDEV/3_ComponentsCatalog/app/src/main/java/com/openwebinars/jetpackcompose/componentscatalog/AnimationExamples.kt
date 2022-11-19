package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun AnimationExercises() {
    // SimpleColorAnimation()
    // SimpleSizeAnimation()
    // SimpleVisibilityAnimation()
    // AdvancedVisibilityAnimation()
    CrossfadeExampleAnimation()
}

@Composable
fun CrossfadeExampleAnimation() {
    var myComponentType: ComponentType by remember { mutableStateOf(ComponentType.Text) }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType=getComponentTypeRandom()}) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponentType ) {
            when (it) {
                ComponentType.Image -> Icon(Icons.Default.Star, contentDescription = "starIcon")
                ComponentType.Text -> Text(text = "Soy un componente")
                ComponentType.Box ->
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .background(Color.Red)
                    )
                ComponentType.Error -> Text(text = "Error")
            }
        }

    }
}
fun getComponentTypeRandom():ComponentType{
    return when (nextInt(from=0, until=3)){
        0-> ComponentType.Image
        1-> ComponentType.Text
        2-> ComponentType.Box
        else-> ComponentType.Error
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}

@Composable
fun AdvancedVisibilityAnimation() {
    Column(Modifier.fillMaxSize()) {
        var showBox by rememberSaveable { mutableStateOf(true) }
        Button(onClick = { showBox = !showBox }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            visible = showBox,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun SimpleVisibilityAnimation() {
    Column(Modifier.fillMaxSize()) {
        var showBox by rememberSaveable { mutableStateOf(true) }
        Button(onClick = { showBox = !showBox }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(visible = showBox) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun SimpleColorAnimation() {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Cyan,
        animationSpec = tween(500),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }

}

@Composable
fun SimpleSizeAnimation() {
    var smallsize by rememberSaveable { mutableStateOf(true) }
    var showBox by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallsize) 50.dp else 100.dp,
        animationSpec = tween(2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(modifier = Modifier
            .size(size)
            .background(Color.Red)
            .clickable { smallsize = !smallsize })
    }

}