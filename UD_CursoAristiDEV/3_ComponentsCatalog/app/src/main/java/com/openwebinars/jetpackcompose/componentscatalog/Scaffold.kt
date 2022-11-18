package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScaffoldExample(){
    Scaffold {
        Box(Modifier.fillMaxWidth().height(50.dp).background(Color.Red)){

        }
    }
}