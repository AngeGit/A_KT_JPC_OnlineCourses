package com.openwebinars.jetpackcompose.componentscatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {

            }
        }

    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() }//Cuando clique fuera
            , title = {
                Row(modifier = Modifier.fillMaxWidth()) {
                    MyIcon()
                    Text(text = "Titulo")
                }
            }, text = {
                Text(text = "Mensaje")
            }, contentColor = Color.Red,
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm Button")
                }
            }, dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss Button")
                }
            }
        )
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Ejemplo de custom Dialog")
                Text(text = "Ejemplo de custom Dialog")
                Text(text = "Ejemplo de custom Dialog")
            }

        }

    }

}

@Composable
fun MyAdvancedCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 12.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Dialog(
                onDismissRequest = { onDismiss() },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                    //   .padding(24.dp)
                ) {

                    MyTitleDialog(text = "Phone ringtone", Modifier.padding(24.dp))
                    Divider(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    var selected by rememberSaveable { mutableStateOf("Opción 1") }
                    MyRadioButtonList(selected = selected, onItemSelected = { selected = it })
                    Divider(
                        Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    Row(
                        Modifier
                            .align(Alignment.End)
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Cancelar")
                        }
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "Aceptar")
                        }

                    }
                }
            }
        }


    }

}


@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )


}

@Composable
fun MyAccountItem(mail: String, @DrawableRes drawable: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = mail,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }

}
