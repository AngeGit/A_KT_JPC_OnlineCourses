package com.openwebinars.jetpackcompose.doglistexercise.ui.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.openwebinars.jetpackcompose.doglistexercise.DogList
import com.openwebinars.jetpackcompose.doglistexercise.data.Dog
import com.openwebinars.jetpackcompose.doglistexercise.getDogsList
import com.openwebinars.jetpackcompose.doglistexercise.ui.theme.DogListExerciseTheme


@Composable
fun MainScreenLayout(dogList:List<Dog>) {
    DogListExerciseTheme() {
        Surface(
            modifier= Modifier.fillMaxSize(),
            color= Color.LightGray
        ){
            DogList(getDogsList())
        }
    }

}
