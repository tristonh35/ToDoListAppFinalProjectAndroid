package com.example.todolistappfinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class EditToDoItemViewModelFactory(private val toDoItemId: Long,
                               private val dao: ToDoItemDAO)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditToDoItemViewModel::class.java)) {
            return EditToDoItemViewModel(toDoItemId, dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}