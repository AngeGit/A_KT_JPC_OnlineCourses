package com.openwebinars.jetpackcompose.previews_and_modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.openwebinars.jetpackcompose.previews_and_modifiers.ui.theme.Previews_and_modifiersTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Previews_and_modifiersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
//region Preview

//Para poder usar preview sin params, la función no tiene que tener params:
@Preview(
    name = "preview greeting 2",
    heightDp = 50,
    widthDp = 200,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_10
)
@Composable
fun Greeting2() {
    Text(text = "Hello Ange :)")
}

/*Para poder usar preview con params, lo más sencillo es envolverlo con
* otra función que no tenga params, y ponérselo a ésta*/
@Preview(
    name = "preview greeting 3",
    heightDp = 50,
    widthDp = 200,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_10
)
@Composable
fun WrapperFunctionGreeting3() {
    Greeting3("Hello Ange :(")
}

@Composable
fun Greeting3(data: String) {
    Text(text = data)
}

//endregion Preview
//region Modifiers
@Preview(
    name = "preview greeting 4",
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun Greeting4() {
    //Code=>Reformat code
    Text(
        text = "Hello Ange :S",
        modifier= Modifier
            .height(20.dp)
            .width(200.dp),
        color= Color.Red,
        fontWeight = FontWeight.Bold

    )

}
//endregion Modifiers
/*


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Previews_and_modifiersTheme {
        Greeting("Android")
    }
}*/
