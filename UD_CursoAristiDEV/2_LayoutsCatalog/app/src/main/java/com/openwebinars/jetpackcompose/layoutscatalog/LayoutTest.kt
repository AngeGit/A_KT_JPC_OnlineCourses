package com.openwebinars.jetpackcompose.jetpackcomposecatalog


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview(
    name = "preview  LayoutTestScreen",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun LayoutTestScreen() {
    testLayout()
}


@Composable
fun testLayout() {
    Column(
        Modifier.fillMaxSize()
    ) {

        createMyTestBox(
            name = "Ejemplo 1",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            alignment = Alignment.Center
        )


        Row(

            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {
            createMyTestBox(
                name = "Ejemplo 2",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red),
                alignment = Alignment.Center
            )
            createMyTestBox(
                name = "Ejemplo 3",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green),
                alignment = Alignment.Center
            )


        }


        createMyTestBox(
            name = "Ejemplo 4",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            alignment = Alignment.BottomCenter
        )
    }

}
@Composable
fun createMyTestBox(name: String, modifier: Modifier, alignment: Alignment) {
    Box(
        modifier = modifier,
        contentAlignment = alignment
    ) {
        createMyTestText(name)
    }
}

@Composable
fun createMyTestText(name: String) {
    Text(
        text = name,
        //.weight(1f)
        style = TextStyle(
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace

        )
    )
}
