package com.openwebinars.jetpackcompose.componentscatalog

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    name = "preview ComponentExercisesScreen",
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5
)
@Composable
fun ComponentExercisesScreen() {
    //MyTextExample()
    //MyTextFieldExample()
    //MyAdvancedTextFieldExample()
    //MyTextfieldOutliner()
    //  var myStateHostingText by remember { mutableStateOf("StateHostingText") }
    //StateHostingExample(myStateHostingText,{myStateHostingText=it}) //Las landas se pueden poner fuera de los paréntesis
    // StateHostingExample(myStateHostingText) {myStateHostingText=it}
    // MyButtonExample()
    //MyOutlinedButtonExample()
    //MyTextButtonExample()
    //MyImageExample()
    //MyAdvancedImageExample()
    // MyIcon()
    //MyProgressBar()
    // MyAdvancedProgressBar()
    //MyAdvancedProgressBar2()
    //MySwitch()
    //MyCheckbox()
    //MyCheckboxWithText("Ejemplo Checkbox con Texto")
    /*var status by rememberSaveable { mutableStateOf(false) }
    val checkInfo = CheckInfo("Ejemplo 1", status, { status = it })*/
    //MyCheckboxWithCheckInfo(checkInfo)
    /*  val myOptions = getCheckboxOptions(titles = listOf("Gil Galad", "Galadriel", "Elrond"))
      showCheckboxOption(myOptions)*/
    // MyRadioButton("My first radiobutton")
  /*  var selected by rememberSaveable { mutableStateOf("Opción 1") }
    MyRadioButtonList(selected,{selected=it})*/
    //MyCard()
   // MyBadgeBox()
   // MyDivider()
    //MyDropDownMenu()
    //MyBasicSlider()
    //MyAdvancedSlider()
    //MyRangedSlider()
/*    var show by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {show=true }) {
            Text(text = "Mostrar Dialog")

        }
     *//*   MyDialog(
            show=show,
            onDismiss = {show=false},
            onConfirm = {
            Log.i("Ange","click")
        })*//*
        *//*MySimpleCustomDialog(show=show,
            onDismiss = {show=false},
         )*//*
        MyAdvancedCustomDialog(show=show,
            onDismiss = {show=false},
        )

    }*/
//SimpleRecyclerView()
    //SuperheroView()
    //SuperheroGridView()
    //SuperheroWithControlView()
   SuperheroStickyView()
   // ScaffoldExample()

}
//region DropdownMenu (Spinner XD)
@Preview
@Composable
fun MyDropDownMenu() {
    var selectedText by remember{mutableStateOf("")}
    var expanded by remember{mutableStateOf(false)}
    val desserts= listOf("Helado","Chocolate")
   Column(
       modifier=Modifier.padding(20.dp)
   ){
        OutlinedTextField(
            value = selectedText,
            onValueChange = {selectedText=it},
            enabled=false,
            readOnly = true,

            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth(),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Cyan)
        )
       DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }, modifier = Modifier.fillMaxWidth()) {
        desserts.forEach { dessert->
            DropdownMenuItem(onClick = {
                expanded=false
                selectedText=dessert
            }) {
                Text(text = dessert)
            }
        }
       }
   }

}
//endregion DropdownMenu (Spinner XD)
//region Divider
@Preview
@Composable
fun MyDivider() {
Divider(modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp), color=Color.Red)
}
//endregion Divider
//region BadgedBox
//@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(30.dp),
        badge = {
            Badge(
                content = {
                    Text(modifier = Modifier.padding(2.dp),text = "10")
                },
                backgroundColor = Color.Black,
                contentColor = Color.White,
                modifier = Modifier.padding(2.dp)
            )
        },
    ){
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Rounded.Star,
            contentDescription = "Icon con BadgedBox",
            tint = Color.Blue
        )
    }
}
//endregion BadgedBox
//region Card
@Composable
fun MyCard(){
    //Por la docu, una card es una surface con una elevación, un shape medium por defecto.
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation=12.dp,
        shape=MaterialTheme.shapes.small,
        backgroundColor = Color.Cyan,
        contentColor=Color.White,
        border=BorderStroke(2.dp,Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)
        ){
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
        }
    }
}
//endregion Card
//region RadioButton
@Composable
fun MyRadioButton2(selected:String,myTitle:String,onItemSelected:(String)->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(
            selected = selected.equals(myTitle),
            onClick = { onItemSelected(myTitle)},
        )
        Text(text = myTitle)
    }
}
@Composable
fun MyRadioButtonList(selected:String, onItemSelected:(String)->Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        MyRadioButton2(selected = selected, myTitle = "Opción 1", onItemSelected = { onItemSelected("Opción 1")  })
        MyRadioButton2(selected = selected, myTitle = "Opción 2", onItemSelected = { onItemSelected("Opción 2")  })
        MyRadioButton2(selected = selected, myTitle = "Opción 3", onItemSelected = { onItemSelected("Opción 3")  })
    }
}
@Composable
fun MyRadioButton(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(
            selected = true,
            enabled = true,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red,
                disabledColor = Color.Yellow
            )
        )
        Spacer(
            modifier = Modifier.width(2.dp)
        )
        Text(
            text = title
        )
    }


}
//endregion RadioButton
//region CheckBox
@Composable
fun MyTriStatusCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = status,
        onClick = {
            status = when (status) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
}

@Composable
fun showCheckboxOption(myOptions: List<CheckInfo>) {
    Column() {
        MyTriStatusCheckbox()
        myOptions.forEach {
            MyCheckboxWithCheckInfo(it)
        }
    }
}

@Composable
fun getCheckboxOptions(titles: List<String>): List<CheckInfo> {
    return titles.map { //Map devuelve la lista de objetos que le metemos cambiado
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckboxWithCheckInfo(info: CheckInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = info.selected,
            onCheckedChange = { info.onCheckedChange(!info.selected) }
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = info.title
        )
    }
}

@Composable
fun MyCheckboxWithText(textoCheckbox: String) {

    var state by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state }

        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = textoCheckbox


        )
    }
}

@Composable
fun MyCheckbox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green,
            checkmarkColor = Color.Black,
            uncheckedColor = Color.Red
        )
    )
}

//endregion CheckBox
//region Switch
@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.1f,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow,

            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f,
            disabledCheckedThumbColor = Color.Yellow,
            disabledCheckedTrackColor = Color.Yellow

        )
    )
}
//endregion switch
//region ProgressBar
@Composable
fun MyAdvancedProgressBar2() {
    var progress by rememberSaveable { mutableStateOf(0.5f) }
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier
                .size(200.dp)
                .padding(top = 100.dp),
            color = Color.Cyan,
            strokeWidth = 5.dp
        )

        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    if (progress < 1) {
                        progress += 0.1f
                    }

                },
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Incrementar")
            }
            OutlinedButton(
                onClick = {
                    if (progress > 0.1f) {
                        progress -= 0.1f
                    }
                },
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Reducir")
            }
        }


    }
}

@Composable
fun MyAdvancedProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Cyan,
                strokeWidth = 5.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Cyan,
                backgroundColor = Color.Magenta
            )
        }
        OutlinedButton(
            onClick = {
                showLoading = !showLoading
            },
            modifier = Modifier.padding(5.dp),

            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column {
                Text(text = "Show")

            }
        }

    }
}

@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color.Cyan,
            strokeWidth = 5.dp
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            color = Color.Cyan,
            backgroundColor = Color.Magenta
        )
    }
}

//endregion ProgressBar
//region Image
@Composable
fun MyIcon() {
    //https://fonts.google.com/icons
    Column {
        Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icono", tint = Color.Red)
        //Icon(imageVector = Icons.Rounded.Call, contentDescription = "Icono", tint = Color.Green)
    }
}

@Preview(
    name = "preview imageAdvanced",
    showBackground = true,
)
@Composable
fun MyAdvancedImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        // modifier=Modifier.clip(RoundedCornerShape(50f))
        modifier = Modifier
            .clip(CircleShape)
            .border(4.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

//endregion Image
//region Buttons
@Composable
fun MyTextButtonExample() {

    TextButton(
        onClick = { })
    {
        Text(text = "TextButton")
    }
}

@Composable
fun MyOutlinedButtonExample() {
    var myEnabledButton by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        OutlinedButton(
            onClick = {
                myEnabledButton = false
                Log.d("Onclick Button", "Has clicado en Hola")
            },
            enabled = myEnabledButton,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Green,
                disabledContentColor = Color.Gray
            ),
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Column {
                Text(text = "Hola")

            }
        }
    }
}

@Composable
fun MyButtonExample() {
    var myEnabledButton by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                myEnabledButton = false
                Log.d("Onclick Button", "Has clicado en Hola")
            },
            enabled = myEnabledButton,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan,
                contentColor = Color.Blue
            ),
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Column {
                Text(text = "Hola")
                // Text(text = "¿Que tal?")
            }
        }
    }
}

//endregion Buttons
//region TextField
@Composable
fun StateHostingExample(name: String, onValueChanged: (String) -> Unit) {
    //Se trata de programar de manera de quitarle "resposabilidad" a los compose,
    // y pasar todas las variables y funciones de los eventos al padre. De esta manera
    //se tiene aceso a estas variables fuera del composable.
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyTextfieldOutliner() {
    //=EditText
    Column {
        var myText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier.padding(24.dp),
            label = { Text(text = "Outlined Example") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Cyan
            )
        )
    }
}

@Composable
fun MyAdvancedTextFieldExample() {
    //=EditText
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            // myText=it
            myText = if (it.contains("a")) {
                it.replace("a", "")

            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyTextFieldExample() {
    //=EditText
    var myText by remember { mutableStateOf("Angie") }
    TextField(value = myText, onValueChange = { myText = it })
}

//endregion TextField
//region Text
@Composable
fun MyTextExample() {
    //=Textview
    //Las hacemos en una column para ver todas las etiquetas:
    Column(Modifier.fillMaxSize()) {
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2", color = Color.Red)
        Text(text = "Ejemplo 3", fontWeight = FontWeight.Light)
        Text(text = "Ejemplo 4", fontWeight = FontWeight.Bold)
        Text(text = "Ejemplo 5", style = TextStyle(fontFamily = FontFamily.Monospace))
        Text(text = "Ejemplo 6", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Ejemplo 7", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Ejemplo 8", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            text = "Ejemplo 9", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Ejemplo 10", fontSize = 30.sp)
    }
}
//endregion Text

