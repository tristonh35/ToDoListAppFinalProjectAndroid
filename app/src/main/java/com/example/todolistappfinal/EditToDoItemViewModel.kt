package com.example.todolistappfinal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EditToDoItemViewModel(toDoItemId : Long, val dao: ToDoItemDAO) : ViewModel() {
    val toDoItem = dao.get(toDoItemId)
    private val _navigateToList = MutableLiveData<Boolean>(false)
    val navigateToList: LiveData<Boolean>get() = _navigateToList

    fun updateToDoItem() {
        viewModelScope.launch {
            dao.update(toDoItem.value!!)
            _navigateToList.value = true
        }
    }

    fun deleteToDoItem() {
        viewModelScope.launch {
            dao.delete(toDoItem.value!!)
            _navigateToList.value = true
        }
    }

    fun onNavigatedToList() {
        _navigateToList.value = false
    }


}