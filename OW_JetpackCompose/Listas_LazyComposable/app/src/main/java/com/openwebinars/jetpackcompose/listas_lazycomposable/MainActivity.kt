package com.openwebinars.jetpackcompose.listas_lazycomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource



import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.openwebinars.jetpackcompose.listas_lazycomposable.ui.theme.Listas_LazyComposableTheme

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
fun MainScreen() {
    Surface(
        modifier=Modifier.fillMaxSize(),
        color= Color.LightGray
    ){
        //    MessageList(messages=listOf("Hola","Adiós"))
        //CardItem()
        CoilItem()
    }
}
//region ejemplo de LazyComposable
@Composable
fun MessageList(messages:List<String>) {
    LazyColumn( modifier=Modifier.fillMaxSize()){
        items(messages){
            message -> MessageInfo(message = message)
        }
    }    
}
@Composable
fun MessageInfo(message:String) {
    Text(text=message)
}
//endregion ejemplo de LazyComposable
//region ejemplo de Card y CoilImage
@Composable
fun CardItem() {
    /*
    * El componente Card es el equivalente del componente CardView.
    * Este componente sirve para mostrar contenido y acciones de un tema determinado
    * aceptando para ello elementos como imágenes o texto. Puedes visitar la documentación de
    * Material Design para obtener más información sobre el uso de este componente.
    * Card acepta un atributo elevation que hace que el componente tenga una elevación sobre el eje Z
    * dando una sensación de profundidad y estableciendo un sombreado sobre su vista padre. */

    Card(
        modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(),
        elevation=10.dp
    ){
        Row(
            Modifier.padding(10.dp)
        ){
            ImageItem()
            Column(
                    Modifier.padding(10.dp)
                    ) {

                androidx.compose.material.Text(text = "Hola")
                androidx.compose.material.Text(text = "This is a card test")

            }

        }

    }
}
@Composable
fun ImageItem() {
    /*El componente Image es el equivalente de ImageView.
    Permite cargar imágenes en Android. Recibe por parámetro:
        painter: Recurso gráfico que se pintará en el componente.
        contentDescription: Corresponde con la descripción de la imagen.
        Será leído por herramientas de accesibilidad.*/
    Image(
        painter= painterResource(id = R.mipmap.ic_example_image ),
        contentDescription="Card image"
    )
}
@Composable
fun CoilItem() {
    /*Coil es una librería de carga de imágenes para Android.
    Está implementada usando coroutines y es muy ligera y fácil de integrar en Jetpack Compose.
    Para su integración hay que incluir la dependencia: implementation(“io.coil-kt:coil-compose:1.3.2”)
    Como es una librería que permite la carga de imágenes de red es indispensable añadir el permiso
    de INTERNET al fichero AndroidManifest.xml.*/
    Image(
        painter = rememberImagePainter("https://images.dog.ceo/breeds/bulldog-boston/n02096585_1761.jpg"),
        contentDescription = "This is a beautiful dog",
        modifier= Modifier.fillMaxSize()
        .wrapContentSize()
    )

}
//endregion ejemplo de Card y CoilImage

