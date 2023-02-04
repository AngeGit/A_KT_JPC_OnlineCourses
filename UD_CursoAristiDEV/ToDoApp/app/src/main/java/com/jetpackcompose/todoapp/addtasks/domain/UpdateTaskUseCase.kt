package com.jetpackcompose.todoapp.addtasks.domain

import com.jetpackcompose.todoapp.addtasks.data.TaskRepository
import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val repository: TaskRepository){
    suspend operator fun invoke(item: TaskModel) = repository.update(item)
}