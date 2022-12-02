package com.jetpackcompose.todoapp.addtasks.ui.screencomponents

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.todoapp.R
import com.jetpackcompose.todoapp.addtasks.ui.TasksViewModel
import com.jetpackcompose.todoapp.addtasks.ui.screencomponents.tasklist.TaskList


@Composable
fun MyScaffoldTaskScreen(tasksViewModel: TasksViewModel) {
    val activity: Activity = LocalContext.current as Activity
    Scaffold(
        topBar = { MyTopAppBar { activity.finish() } },
        floatingActionButton = { MyFAB { tasksViewModel.onShowDialogClicked() } },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        TaskList(tasksViewModel)
    }
}

@Composable
fun MyFAB(onClickFab: () -> Unit) {
    FloatingActionButton(
        backgroundColor = colorResource(id = R.color.fab),
        contentColor = colorResource(id = R.color.fab_content),
        onClick = { onClickFab()}
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.cnt_desc_add))
    }
}
@Composable
fun MyTopAppBar(onCloseIcon: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                Modifier.padding(horizontal = 16.dp),
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp
            )
        },
        backgroundColor = colorResource(id = R.color.topbar),
        contentColor = colorResource(id = R.color.white),
        elevation = 32.dp,
        actions = {
            IconButton(onClick = { onCloseIcon() }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = stringResource(id = R.string.cnt_desc_close))
            }
        }
    )
}
