package com.example.todolistappfinal.ui.tomorrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TomorrowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is where tomorrows to do list will be"
    }
    val text: LiveData<String> = _text
}