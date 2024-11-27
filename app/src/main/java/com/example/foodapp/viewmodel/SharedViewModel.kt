package com.example.foodapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String> get() = _userId

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun setUserCredentials(id: String, pw: String) {
        _userId.value = id
        _password.value = pw
    }
}