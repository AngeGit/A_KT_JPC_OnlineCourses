package com.jetpackcompose.todoapp.addtasks.ui


import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.todoapp.addtasks.ui.screencomponents.addtaskdialog.AddTaskDialog
import com.jetpackcompose.todoapp.addtasks.ui.screencomponents.MyScaffoldTaskScreen
import com.jetpackcompose.todoapp.R

@Preview
@Composable
fun showPreview() {
    TasksScreen(tasksViewModel = TasksViewModel())
}

@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {
    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(false)
    var context=LocalContext.current
    var msgToast:String = stringResource(id = R.string.empty_task)
    AddTaskDialog(
        show = showDialog,
        onDismiss = { tasksViewModel.onDialogClose() },
        onTaskAdded = {
            if(it.isNotEmpty()){
                tasksViewModel.onTaskCreated(it)
            }else{

                Toast.makeText(context,msgToast,Toast.LENGTH_LONG).show()
            }
        })
    MyScaffoldTaskScreen(tasksViewModel)
}
