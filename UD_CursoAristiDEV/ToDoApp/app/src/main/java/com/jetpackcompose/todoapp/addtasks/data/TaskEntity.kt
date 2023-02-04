package com.jetpackcompose.todoapp.addtasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class TaskEntity (
    @PrimaryKey
    val id:Int,
    val taskName:String,
    var done:Boolean=false
)