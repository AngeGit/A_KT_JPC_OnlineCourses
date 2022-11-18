package com.openwebinars.jetpackcompose.componentscatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
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
            MyTopAppBar (
                onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                }},
                onClickDrawer = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                } )

        },

        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigationBar()},
        floatingActionButton = { MyFAB()},
        floatingActionButtonPosition = FabPosition.Center,
        //isFloatingActionButtonDocked = true //En casos que tengamos sólo dos botones, el fab se puede "incorporar" a la bottombar
        drawerContent = { MyDrawer( onCloseDrawer = {
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }
        } )}
    //, drawerGesturesEnabled = false //Para que no salga el drawer arrastrando, por defecto a true

    ) {//Como el esqueleto de una pantalla, le añadimos los componentes y él los ajusta.

    }
}
@Composable
fun MyDrawer(onCloseDrawer:()->Unit){//Menú hamburguesa??!! XD
    Column(Modifier.padding(8.dp)){
        Text(text = "Primera opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onCloseDrawer() } )
        Text(text = "Segunda opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onCloseDrawer() } )
        Text(text = "Tercera opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onCloseDrawer() } )
        Text(text = "Cuarta opción", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp).clickable { onCloseDrawer() } )
    }
}
@Composable
fun MyFAB(){
    FloatingActionButton(backgroundColor = Color.Yellow, contentColor = Color.Black, onClick = { }) {
        Icon(imageVector = Icons.Filled.Add , contentDescription = "Add" )
    }
}

@Composable
fun MyBottomNavigationBar() {
    var index by remember{ mutableStateOf(0) }
    BottomNavigation (
        backgroundColor = Color.Red, contentColor = Color.White
            ){
        BottomNavigationItem(
            selected = index==0,
            onClick = { index=0},
            icon = 
            {Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
            )
        BottomNavigationItem(
            selected = index==1,
            onClick = {  index=1},
            icon =
            {Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite") },
            label = { Text(text = "Favorite") }
        )
        BottomNavigationItem(
            selected = index==2,
            onClick = { index=2 },
            icon =
            {Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
            label = { Text(text = "Person") }
        )
    }
    
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) { //=toolbar
    TopAppBar(
        title = {
            Text(text = "Ange toolbar")
        },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 8.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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