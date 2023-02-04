package com.jetpackcompose.todoapp.addtasks.ui

import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel

sealed interface TasksUIState{
    //Posibles estados de la UI : Cargando, pantalla de error y pantalla en la que pinta normal los datos
    object Loading:TasksUIState
    data class Error(val throwable: Throwable)
    data class Success(val tasks:List<TaskModel>):TasksUIState
}