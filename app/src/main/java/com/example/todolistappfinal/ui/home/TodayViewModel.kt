package com.example.todolistappfinal.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is where you can add to do items for today"
    }
    val text: LiveData<String> = _text
}