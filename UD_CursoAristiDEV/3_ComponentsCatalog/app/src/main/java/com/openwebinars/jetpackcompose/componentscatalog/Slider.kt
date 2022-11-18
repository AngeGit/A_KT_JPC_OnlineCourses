package com.openwebinars.jetpackcompose.componentscatalog


import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun MyBasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember{mutableStateOf(0f)}
        Slider(value = sliderPosition, onValueChange = {sliderPosition=it})
        Text(text = sliderPosition.toString())
    }
}
@Preview
@Composable
fun MyAdvancedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember{mutableStateOf(0f)}
        var completeValue by remember{mutableStateOf("")}
        Slider(
            value = sliderPosition,
            onValueChange = {sliderPosition=it},
            valueRange = 0f..10f,
            steps=9, //A los steps hay que quitarle 2
            onValueChangeFinished = {completeValue=sliderPosition.toString()}
        )
        Text(text =completeValue)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MyRangedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentRange by remember{mutableStateOf(0f..10f)}
        RangeSlider(
            values = currentRange,
            onValueChange = {currentRange=it}, valueRange = 0f..40f,
            steps = 9 //A los steps hay que quitarle 2
        )
        Text(text ="Valor inferior: ${currentRange.start.toString()}")
        Text(text ="Valor superior: ${currentRange.endInclusive.toString()}")
    }
}