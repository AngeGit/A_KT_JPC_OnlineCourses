package com.jetpackcompose.todoapp.addtasks.data

import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao:TaskDao) {
    val tasks: Flow<List<TaskModel>> =
        taskDao.getTasks().map {//hay que hacer dos .map, uno para el flow y otro para el list
                items->items.map{
                    it.toTaskModel()
                }
        }
    suspend fun add(item: TaskModel){
        taskDao.addTask(item.toTaskEntity())
    }
    suspend fun delete(item: TaskModel){
        taskDao.deleteTask(item.toTaskEntity())
    }
    suspend fun update(item: TaskModel){
        taskDao.updateTask(item.toTaskEntity())
    }
}
//Creamos las funciones de extensión para pasar del modelo de la capa datos al modelo de la capa ui y viceversa:
fun TaskModel.toTaskEntity():TaskEntity=TaskEntity(this.id,this.taskName,this.done)
fun TaskEntity.toTaskModel():TaskModel=TaskModel(this.id,this.taskName,this.done)