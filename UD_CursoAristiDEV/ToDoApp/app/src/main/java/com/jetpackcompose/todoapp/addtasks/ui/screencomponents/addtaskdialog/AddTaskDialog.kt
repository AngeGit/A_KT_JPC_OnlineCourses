package com.jetpackcompose.todoapp.addtasks.ui.screencomponents.addtaskdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jetpackcompose.todoapp.R

@Composable
fun AddTaskDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit) {
    var myTask by remember { mutableStateOf("") }
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.white))
                    .padding(24.dp)
            ) {
                Text(
                    text =  stringResource(id = R.string.add_task_dialog_title),
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.addtaskdialogtitle)
                )
                Spacer(modifier = Modifier.size(24.dp))
                TextField(
                    value = myTask, onValueChange = { myTask = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor=Color.Transparent,
                        textColor = colorResource(id = R.color.black),
                        cursorColor = colorResource(id = R.color.lightindicator),
                        focusedIndicatorColor = colorResource(id =  R.color.lightindicator),
                        unfocusedIndicatorColor = colorResource(id = R.color.darkindicator)
                    )
                )
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    onClick = {
                        onTaskAdded(myTask)
                        myTask=""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.addtaskdialogbutton),
                        contentColor = colorResource(id = R.color.white)
                    )
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.cnt_desc_add),
                        tint=colorResource(id = R.color.white),
                        modifier = Modifier
                            .size(36.dp)
                    )
                }
            }

        }
    }
}