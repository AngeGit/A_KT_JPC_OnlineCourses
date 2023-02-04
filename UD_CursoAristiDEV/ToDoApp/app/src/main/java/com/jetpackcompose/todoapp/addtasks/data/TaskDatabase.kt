package com.jetpackcompose.todoapp.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version=1)
abstract class TaskDatabase:RoomDatabase(){
    //DAO:Interfaz que nos permite hacer las consultas sql
    abstract fun taskDao():TaskDao
}