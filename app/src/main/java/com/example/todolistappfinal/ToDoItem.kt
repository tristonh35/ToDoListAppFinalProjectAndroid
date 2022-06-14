package com.example.todolistappfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoitem_table")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    var toDoItemId: Long = 0L,
    @ColumnInfo(name = "todoitem_name")
    var toDoItemName: String = "",
    @ColumnInfo(name = "todoitem_done")
    var toDoItemDone: Boolean = false
)