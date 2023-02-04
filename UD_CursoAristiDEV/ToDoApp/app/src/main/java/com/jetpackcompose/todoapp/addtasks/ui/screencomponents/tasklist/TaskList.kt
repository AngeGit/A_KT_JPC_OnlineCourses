package com.jetpackcompose.todoapp.addtasks.ui.screencomponents.tasklist

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.jetpackcompose.todoapp.R
import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel


@Composable
fun TaskList(
    tasks: List<TaskModel>,
    onTaskDeleted: (TaskModel) -> Unit,
    onTaskUpdated: (TaskModel) -> Unit
) {
    LazyColumn{
        items(tasks, key= { it.id}) { task->
            TaskItem(task,onTaskDeleted,onTaskUpdated)
        }
    }
}

@Composable
fun TaskItem(
    taskModel: TaskModel,
    onTaskDeleted: (TaskModel) -> Unit,
    onTaskUpdated: (TaskModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = { onTaskDeleted(taskModel) })
            },
        shape= MaterialTheme.shapes.small,
        backgroundColor = colorResource(id = R.color.item_card),
        contentColor = colorResource(id = R.color.txt_item_card),
        elevation = 0.5.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = taskModel.taskName,
                modifier = Modifier
                    .weight(1f)
            )
            Checkbox(
                checked = taskModel.done,
                onCheckedChange = { onTaskUpdated(taskModel) },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.chk_item_card),
                    uncheckedColor = colorResource(id = R.color.chk_item_card),
                    checkmarkColor = colorResource(id = R.color.white)
                )
            )
        }
    }

}
