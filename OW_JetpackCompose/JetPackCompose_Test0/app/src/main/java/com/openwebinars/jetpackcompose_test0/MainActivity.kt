package com.openwebinars.jetpackcompose_test0

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           val students= remember{mutableStateListOf("Elrond", "Gil Galad", "Círdan")}
           val newStudentState = remember { mutableStateOf("") }
           //MainScreen()
           //Premisa del patrón State Hosting: el componente hijo no sabe nada de estados, lo gestiona el componente padre
            ElvesListMainScreen(
                students,
                { students.add(newStudentState.value) },
                newStudentState.value,
                { newStudent -> newStudentState.value = newStudent }
            )
           /*GreetingText("Ange")*/
            //ButtonGreeting("Ange")
         /*   JetPackCompose_Test0Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }*/
        }
    }
}
@Composable
fun ElvesListMainScreen(
    students:List<String>,
    onButtonClicked:() ->Unit,
    studentName:String,
    onStudentNameChanged:(String)->Unit
) {
    //LA FUNCIÓN ES SÓLO PINTAR DATOS

    //val students= mutableListOf("Galadriel", "Gil Galad", "Círdan")

    Column(
        modifier=Modifier.fillMaxSize()
    ){
       for(student in students){
           Text(text= student)
       }
        var newElfState=remember{
            mutableStateListOf("")
        }
        TextField(
            value = studentName,
            onValueChange = onStudentNameChanged)
        Button(modifier=Modifier.wrapContentSize(Alignment.BottomEnd),
            onClick = onButtonClicked) {
            Text(text = "Add most Mary-Sued elf ever")
        }

    }


}
@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color=Color.LightGray
    ){
       /* Surface(
            modifier= Modifier
                .wrapContentSize(Alignment.TopStart)
                .padding(50.dp),
            color=Color.Blue
        ){
            GreetingText("Ange")
        }*/
        Column(
            modifier = Modifier
                .fillMaxSize()
                /*       .wrapContentSize(Alignment.TopEnd)*/
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GreetingText("Ange")
            GreetingText("Ange")
            componenteReutilizadoSurface(color = Color.Green, size = 50)
            componenteReutilizadoSurface(color = Color.Blue, size = 150)
           /* Surface(color=Color.Red, modifier= Modifier.size(50.dp
            )){

            }*/
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    /*       .wrapContentSize(Alignment.TopEnd)*/
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ){
                componenteReutilizadoSurface(color = Color.Red, size = 50)
                componenteReutilizadoSurface(color = Color.DarkGray, size = 150)
            }
        }

    }
}
@Composable
fun componenteReutilizadoSurface(color:Color, size:Int){
    Surface(color=color, modifier= Modifier.size(size.dp
    )){

    }
}

@Composable
fun GreetingText(name: String) {
 /*   Text(text = "Hello $name!",
        modifier=Modifier.fillMaxWidth(),*//*Fraction es la fracción de lo que puede ocupar del padre
       Si ponemos el padding en ultimo lugar, el padding será clicable,
        si va antes no.*//*
        modifier=Modifier
            .fillMaxHeight(0.5f)
            .padding(all=10.dp)
            .padding(top=5.dp)
            .clickable {
                    Log.d("TAG","Test clicado")
            },
         modifier=Modifier.fillMaxSize(),
        modifier=Modifier
                    .width(80.dp)
                    .height(240.dp),
        color= Color.Green)*/

    //Customizar una función Text:
    //Se puede sobreescibir el style que elijamos
    Text(text = "Hello $name!",
        style= MaterialTheme.typography.h5,
        color=Color.Gray,
        fontWeight = FontWeight.Light,
        modifier=Modifier.wrapContentSize()
  /*      style=
    androidx.compose.ui.text.TextStyle(
        color = Color.Cyan,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif


        )*/
    )

}
@Composable
fun ButtonGreeting(name:String) {
    //rowscope espacio reservado para una fila,un contentedor de elementos de forma horizontal
    //Por defecto button no tiene texto, ni imagen ni nada
    Button(onClick = {
        //To do:
        Log.d("TAG","On click $name")
    }) {
        GreetingText(name = name)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //Esta función constuye lo que se ve en el Design (lo que se previsualiza)
    //Acuérdate de darle al Build&Refresh
    val students= remember{mutableStateListOf("Elrond", "Gil Galad", "Círdan")}
    val newStudentState = remember { mutableStateOf("") }
    //MainScreen()
    //Premisa del patrón State Hosting: el componente hijo no sabe nada de estados, lo gestiona el componente padre
    ElvesListMainScreen(
        students,
        { students.add(newStudentState.value) },
        newStudentState.value,
        { newStudent -> newStudentState.value = newStudent }
    )
    //MainScreen()
  // GreetingText("Ange")
    //ButtonGreeting("Ange")
   /* JetPackCompose_Test0Theme {
        Greeting("Android")
    }*/
}