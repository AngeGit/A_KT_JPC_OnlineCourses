package com.jetpackcompose.todoapp.addtasks.ui


import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.jetpackcompose.todoapp.addtasks.ui.screencomponents.addtaskdialog.AddTaskDialog
import com.jetpackcompose.todoapp.addtasks.ui.screencomponents.MyScaffoldTaskScreen
import com.jetpackcompose.todoapp.R
import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel



@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {
    val activity: Activity = LocalContext.current as Activity
    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(false)

    val lifecycle= LocalLifecycleOwner.current.lifecycle //Snapshot del state
    val uiState by produceState<TasksUIState>(
        initialValue = TasksUIState.Loading,
        key1 = lifecycle,
        key2= tasksViewModel
    ){
        lifecycle.repeatOnLifecycle(state=Lifecycle.State.STARTED){
            tasksViewModel.uiState.collect { value = it }
        }
    }
    when(uiState){
        is Error -> {

        }
        TasksUIState.Loading -> {

        }
        is TasksUIState.Success -> {
         showSuccessScreen(
             onCloseApp = { activity.finish() },
             showDialog,
             closeTaskDialog={ tasksViewModel.onDialogClose() },
             openTaskDialog={tasksViewModel.onShowDialogClicked()},
             onTaskAdded = {tasksViewModel.onTaskCreated(it) },
             tasks=((uiState as TasksUIState.Success).tasks),
             onTaskDeleted={ tasksViewModel.onItemRemove(it) },
             onTaskUpdated={ tasksViewModel.onTaskChkSelected(it) }
         )
        }
    }


}
@Composable
fun showSuccessScreen(
    onCloseApp: () -> Unit,
    showDialog: Boolean,
    closeTaskDialog: () -> Unit,
    openTaskDialog: () -> Unit,
    onTaskAdded: (item:String) -> Unit,
    tasks: List<TaskModel>,
    onTaskDeleted: (TaskModel) -> Unit,
    onTaskUpdated: (TaskModel) -> Unit
) {
    var context=LocalContext.current
    var msgToast:String = stringResource(id = R.string.empty_task)

    AddTaskDialog(
        show = showDialog,
        onDismiss = {closeTaskDialog()},
        onTaskAdded = {
            if(it.isNotEmpty()){
                onTaskAdded(it)
            }else{
                Toast.makeText(context,msgToast,Toast.LENGTH_LONG).show()
            }
        })
    MyScaffoldTaskScreen(onCloseApp, openTaskDialog, tasks, onTaskDeleted,onTaskUpdated)
}
