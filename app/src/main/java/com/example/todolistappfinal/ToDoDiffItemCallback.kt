package com.example.todolistappfinal

import androidx.recyclerview.widget.DiffUtil

class ToDoDiffItemCallback : DiffUtil.ItemCallback<ToDoItem>() {
    override fun areItemsTheSame(oldItem: ToDoItem, newItem: ToDoItem)
            = (oldItem.toDoItemId == newItem.toDoItemId)
    override fun areContentsTheSame(oldItem: ToDoItem, newItem: ToDoItem) = (oldItem == newItem)
}