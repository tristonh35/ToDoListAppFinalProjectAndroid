package com.example.todolistappfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistappfinal.databinding.TodoItemBinding

class ToDoItemAdapter(val clickListener: (toDoItemId : Long) -> Unit) : ListAdapter<ToDoItem, ToDoItemAdapter.ToDoItemViewHolder>(ToDoDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ToDoItemViewHolder = ToDoItemViewHolder.inflateFrom(parent)
    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
    class ToDoItemViewHolder(val binding: TodoItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun inflateFrom(parent: ViewGroup): ToDoItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
                return ToDoItemViewHolder(binding)
            }
        }
        fun bind(item: ToDoItem, clickListener: (toDoItemId: Long) -> Unit) {
            binding.toDoItem = item
            binding.root.setOnClickListener {clickListener(item.toDoItemId)}
        }
    }
}

