package com.openwebinars.jetpackcompose.jetpackcomposecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
    name = "preview myBox",
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5
)
@Composable
fun LayoutExercisesScreen() {
        //MyBox()
        //MyColumn()
        //MyRow()
       // MyComplexLayout()
    MyStateExample()
}

//region Ejercicio Box
@Preview(
    name = "preview myBox",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Red)
                .verticalScroll(
                    rememberScrollState()
                )//,
            //contentAlignment = Alignment.BottomCenter //Para alinear el texto dentro de la box
        ) {
            Text(
                "Por defecto los box tienen un tamaño wrap content, tanto en height como en width. Si lo acotamos nosotros, podemos poner un scroll para que no se corte el texto y se pueda leer ",
            )
        }
    }
}

//endregion ejercicio Box
//region Ejercicio Rows&Columns
@Preview(
    name = "preview myRow",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyRow() {
    //Como un linear layout horizontal
    Row(
        modifier = Modifier
            .fillMaxSize() //Por defecto las column nacen a tamaño wrap content
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        createMyText("Ejemplo 1", Color.Red)
        createMyText("Ejemplo 2", Color.Blue)
        createMyText("Ejemplo 3", Color.Green)
        createMyText("Ejemplo 4", Color.Yellow)
        createMyText("Ejemplo 5", Color.DarkGray)
        createMyText("Ejemplo 6", Color.Cyan)
        createMyText("Ejemplo 7", Color.Magenta)
        createMyText("Ejemplo 1", Color.Red)
        createMyText("Ejemplo 2", Color.Blue)
        createMyText("Ejemplo 3", Color.Green)
        createMyText("Ejemplo 4", Color.Yellow)
        createMyText("Ejemplo 5", Color.DarkGray)

    }

}
@Preview(
    name = "preview myColumn",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyColumn() {
    //Como un linear layout vertical
    Column(
        modifier = Modifier
            .fillMaxSize() //Por defecto las column nacen a tamaño wrap content
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,

        ) {
        createMyText("Ejemplo 1", Color.Red)
        createMyText("Ejemplo 2", Color.Blue)
        createMyText("Ejemplo 3", Color.Green)
        createMyText("Ejemplo 4", Color.Yellow)
        createMyText("Ejemplo 5", Color.DarkGray)
        createMyText("Ejemplo 6", Color.Cyan)
        createMyText("Ejemplo 7", Color.Magenta)
    }

}

@Composable
fun createMyText(name: String, color: Color) {
    Text(
        text = name,
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .height(200.dp),
        //.weight(1f)
        style = TextStyle(
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.End
        )
    )
}

//endregion Ejercicio Rows&Columns
//region Ejercicio MyComplexLayout
@Preview(
    name = "preview MyComplexLayout",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyComplexLayout() {
    Column(
        Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red)
        ) {

        }
        MySpacer(height = 30)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Other Text",
                    modifier = Modifier
                        .background(Color.Yellow),
                    //.weight(1f)

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Magenta),
                contentAlignment = Alignment.Center
            ) {
                createMyText("Hola Angie", Color.Red)
            }
        }
        MySpacer(height = 80)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow)
        ) {

        }
    }

}
@Composable
fun MySpacer(height:Int) {
    Spacer(modifier = Modifier.height(height.dp) )
}
//endregion Ejercicio MyComplexLayout
//region MyStateExample
@Preview(
    name = "preview myStateExample",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyStateExample() {
    /*La función remember sólo funciona para recrear cuando el Composable se carga de nuevo, pero
    * la activity sigue intacta, si se rompe, el composable se carga de nuevo sin que el remember
    * haya metido nada en el bundle. Para mantener el estado aunque la vista se destruya, hay que usar
    * la función rememberSaveable*/

    //var counter= rememberSaveable{mutableStateOf(0)}
    var counter by rememberSaveable{mutableStateOf(0)} //State property
    Column(
        modifier = Modifier
            .fillMaxSize(), //Por defecto las column nacen a tamaño wrap content
         verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Button(onClick = {
       // counter.value+=1
            counter+=1
        }) {
            Text("Pulsar")
        }
      //  Text("He sido pulsado ${counter.value} veces")
        Text("He sido pulsado ${counter} veces")
    }

}
//endregion MyStateExample

