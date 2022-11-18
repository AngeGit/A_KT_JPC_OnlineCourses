package com.openwebinars.jetpackcompose.doglistexercise

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.openwebinars.jetpackcompose.doglistexercise.data.Dog

@Composable
fun DogList(dogsList: List<Dog>) {
    LazyColumn(modifier= Modifier.fillMaxWidth().wrapContentSize()){
        items(dogsList){
                dog->DogItem(dog)
        }
    }
}