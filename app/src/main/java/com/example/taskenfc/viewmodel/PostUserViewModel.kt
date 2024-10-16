package com.example.taskenfc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskenfc.model.PostUser
import com.example.taskenfc.repository.Repository
import kotlinx.coroutines.launch

class PostUserViewModel(private val repository: Repository) : ViewModel() {

    private val _postUserData = MutableLiveData<List<PostUser>>()
    val postUserData: LiveData<List<PostUser>> get() = _postUserData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchPostUserData() {
        viewModelScope.launch {
            try {
                val data = repository.getPostUserData()
                if (data != null) {
                    _postUserData.postValue(data)
                } else {
                    _error.postValue("Error fetching data")
                }
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}