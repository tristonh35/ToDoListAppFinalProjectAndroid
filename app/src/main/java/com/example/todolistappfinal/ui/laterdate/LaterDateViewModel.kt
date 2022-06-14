package com.example.todolistappfinal.ui.laterdate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LaterDateViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is where you can add to do objects for a later date"
    }
    val text: LiveData<String> = _text
}