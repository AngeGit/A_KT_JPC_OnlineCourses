package com.jetpackcompose.todoapp.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class TasksViewModel @Inject constructor():ViewModel() {

    private val TAG : String="::::::::::: TASKVIEWMODEL ::::::::::::::::"
    private val _showDialog = MutableLiveData(false)
    val showDialog: LiveData<Boolean> =_showDialog

    private val _tasks= mutableStateListOf<TaskModel>() //NO LIVE DATA=> Optimizado para Listas y RecyclerViews.
    val tasks: List<TaskModel> = _tasks

    fun onDialogClose() {_showDialog.value=false}
    fun onShowDialogClicked() { _showDialog.value=true}
    fun onTaskCreated(task: String) {
        onDialogClose()
            _tasks.add(TaskModel(taskName = task))
            Log.d(TAG,"TASK CREATED= $task")
    }
    fun onTaskChkSelected(taskModel: TaskModel) {
        val index=_tasks.indexOf(taskModel) //Recogemos la posición del item en la lista
        //mutableStateListOf can only notify about adding/removing/replacing some element in the list.
        // When you change any class inside the list, the mutable state cannot know about it.
        //si hacemos un _tasks[index].done=true no va a funcionar.

        //Data classes are very good for storing immutable state in unidirectional data flow,
        // because you can always "change" it with copy, while you see the need to pass the new data to view
        // or mutable state. So avoid using var variables with data classes, always declare them as val
        // to prevent such errors.
        _tasks[index]=_tasks[index].let{
            it.copy(done=!it.done)          //Hacemos una copia con el valor cambiado
        }
    }
    fun onItemRemove(taskModel: TaskModel) {
        val task= _tasks.find { it.id==taskModel.id }
        _tasks.remove(task)
    }

}