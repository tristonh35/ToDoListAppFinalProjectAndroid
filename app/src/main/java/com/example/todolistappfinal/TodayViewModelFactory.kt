package com.example.todolistappfinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TodayViewModelFactory(private val dao: ToDoItemDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TodayViewModel::class.java)) {
            return TodayViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}