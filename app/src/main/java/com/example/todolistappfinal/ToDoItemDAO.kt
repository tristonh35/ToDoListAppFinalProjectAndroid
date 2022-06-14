package com.example.todolistappfinal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ToDoItemDAO {
    @Insert
    suspend fun insert(toDoItem: ToDoItem)
    @Update
    suspend fun update(toDoItem: ToDoItem)
    @Delete
    suspend fun delete(toDoItem: ToDoItem)
    @Query("SELECT * FROM todoitem_table WHERE toDoItemId = :key")
    fun get(key: Long): LiveData<ToDoItem>
    @Query("SELECT * FROM todoitem_table ORDER BY toDoItemId DESC")
    fun getAll(): LiveData<List<ToDoItem>>
}