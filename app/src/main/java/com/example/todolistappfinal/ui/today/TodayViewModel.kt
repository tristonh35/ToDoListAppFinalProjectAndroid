package com.example.todolistappfinal

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodayViewModel(val dao: ToDoItemDAO) : ViewModel() {
    var newToDoItemName = ""
    val todoitems = dao.getAll()

    private val _navigateToToDoItem = MutableLiveData<Long?>()
    val navigateToToDoItem : LiveData<Long?>
            get() = _navigateToToDoItem

    val toDoItemString = Transformations.map(todoitems) {
            toDoItems -> formatToDoItems(toDoItems)
    }
    fun addToDoItem() {
        viewModelScope.launch {
            val toDoItem = ToDoItem()
            toDoItem.toDoItemName = newToDoItemName
            dao.insert(toDoItem)
        }
    }
    fun onToDoItemClicked(toDoItemId : Long) {
        _navigateToToDoItem.value = toDoItemId
    }
    fun onToDoItemNavigated() {
        _navigateToToDoItem.value = null
    }


    fun formatToDoItems(toDoItems: List<ToDoItem>): String {
        return toDoItems.fold("") {
                str, item -> str + '\n' + formatToDoItem(item)
        }
    }
    fun formatToDoItem(todoitem: ToDoItem): String {
        var str = "ID: ${todoitem.toDoItemId}"
        str += '\n' + "Name: ${todoitem.toDoItemName}"
        str += '\n' + "Complete: ${todoitem.toDoItemDone}" + '\n'
        return str
    }
}