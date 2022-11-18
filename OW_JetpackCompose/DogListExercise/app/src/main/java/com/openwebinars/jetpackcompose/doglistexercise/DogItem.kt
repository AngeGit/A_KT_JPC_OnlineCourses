package com.openwebinars.jetpackcompose.doglistexercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.openwebinars.jetpackcompose.doglistexercise.data.Dog


@Composable
fun DogItem(dog: Dog) {

    Card(
        modifier= Modifier
            .fillMaxWidth()
            .wrapContentSize(),
        elevation=10.dp
    ){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .wrapContentSize(),
            horizontalArrangement = Arrangement.Start

        ){
            LoadCoilImage(dog)
            Column(
                modifier= Modifier
                    .padding(start=20.dp)
            ) {
                PrintDogInfo(dog.name, true)
                PrintDogInfo("Raza: ${dog.breed}", false)
                PrintDogInfo( "Años: ${dog.age.toString()}", false)
            }
        }
    }
}


@Composable
fun LoadCoilImage(dog: Dog) {
    Image(
        painter = rememberImagePainter(dog.imageUrl),
        contentDescription = dog.getDogImageDescription(),
        modifier= Modifier.size(150.dp),
        contentScale=ContentScale.Crop,
       alignment = Alignment.CenterStart
    )
}

@Composable
fun PrintDogInfo(info: String, isNameInfo: Boolean) {
    var style= MaterialTheme.typography.body2
    if(isNameInfo){
        style= MaterialTheme.typography.h4
    }
    Text(text=info, style=style)
}
