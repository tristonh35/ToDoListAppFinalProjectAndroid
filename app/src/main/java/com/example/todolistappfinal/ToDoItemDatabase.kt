package com.example.todolistappfinal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoItemDatabase : RoomDatabase() {
    abstract val todoitemDao: ToDoItemDAO
    companion object {
        @Volatile
        private var INSTANCE: ToDoItemDatabase? = null
        fun getInstance(context: Context): ToDoItemDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoItemDatabase::class.java,
                        "todoitem_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}