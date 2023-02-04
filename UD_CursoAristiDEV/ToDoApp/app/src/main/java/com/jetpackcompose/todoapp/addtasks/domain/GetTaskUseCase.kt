package com.jetpackcompose.todoapp.addtasks.domain

import com.jetpackcompose.todoapp.addtasks.data.TaskRepository
import com.jetpackcompose.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskModel>> = repository.tasks
}