package com.openwebinars.jetpackcompose.practica_viewmodel_livedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.openwebinars.jetpackcompose.practica_viewmodel_livedata.ui.theme.Practica_ViewModel_LiveDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}


@Composable
fun MainScreen(viewModel: MainViewModel=MainViewModel()) {
  val nameState=viewModel.textfieldNameState.observeAsState("") //observeAsState is part of the runtime-livedata library.

   Surface(
        modifier=Modifier.fillMaxSize(),
        color= Color.LightGray
    ){
     MainLayout(
         nameState.value
     ){
         newName->viewModel.onTextFieldChanged(newName)
     }
    }
}

@Composable
fun MainLayout(
    name:String,
    onTextfieldChange:(String)->Unit
) {
    Column(
        modifier=Modifier.fillMaxWidth()
    ){
        TextField(
            value= name,
            onValueChange = onTextfieldChange
        )
        Text(text = name)
    }
}
