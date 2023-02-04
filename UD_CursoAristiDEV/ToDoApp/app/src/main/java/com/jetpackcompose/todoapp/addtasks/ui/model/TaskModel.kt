package com.jetpackcompose.todoapp.addtasks.ui.model

data class TaskModel(
    val id:Int= System.currentTimeMillis().hashCode(),
    val taskName:String,
    var done:Boolean=false
)
