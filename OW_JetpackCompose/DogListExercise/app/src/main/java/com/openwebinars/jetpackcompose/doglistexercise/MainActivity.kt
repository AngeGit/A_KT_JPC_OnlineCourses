package com.openwebinars.jetpackcompose.doglistexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.openwebinars.jetpackcompose.doglistexercise.data.Dog
import com.openwebinars.jetpackcompose.doglistexercise.ui.layouts.MainScreenLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenLayout(getDogsList())
        }
    }
}

@Preview(name = "mainActivity", showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreenLayout(getDogsList())
}



fun getDogsList(): List<Dog>{
    return listOf(
        Dog("Dado", "Breed 1",2,"https://img.webme.com/pic/r/refugiohappydog/dado.jpg"),
        Dog("Elvis", "Breed 2",1,"https://img.webme.com/pic/r/refugiohappydog/elvis1.jpg"),
        Dog("Sugus", "Breed 3",2,"https://img.webme.com/pic/r/refugiohappydog/sugus4.jpg"),
        Dog("Jade", "Breed 4",1,"https://img.webme.com/pic/r/refugiohappydog/resized_jade3.jpg"),
        Dog("Mery", "Breed 5",2,"https://img.webme.com/pic/r/refugiohappydog/mery.jpg"),
        Dog("Dama", "Breed 6",3,"https://img.webme.com/pic/r/refugiohappydog/dama1.jpg"),
    )
}
