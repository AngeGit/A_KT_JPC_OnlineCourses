package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope =
        rememberCoroutineScope() //Hay algunos elementos como el snackbar, que necesitan de una corrutina

    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                }
            }
        },
        scaffoldState = scaffoldState
    ) {//Como el esqueleto de una pantalla, le añadimos los componentes y él los ajusta.

    }
}



@Composable
fun MyBottomNavigationBar(){

}
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) { //=toolbar
    TopAppBar(
        title = {
            Text(text = "Ange toolbar")
        },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 8.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("back") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("shopping cart") }) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "shopping cart")
            }
            IconButton(onClick = { onClickIcon("star") }) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "star")
            }
        }
    )
}