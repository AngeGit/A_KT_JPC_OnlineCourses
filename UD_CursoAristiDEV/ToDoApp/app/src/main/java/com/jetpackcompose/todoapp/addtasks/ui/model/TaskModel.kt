package com.jetpackcompose.todoapp.addtasks.ui.model

data class TaskModel(
    val id:Long= System.currentTimeMillis(),
    val taskName:String,
    var done:Boolean=false
)
