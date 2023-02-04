package com.nohjunh.test.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.test.database.entity.ContentEntity
import com.nohjunh.test.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val databaseRepository = DatabaseRepository()

    private var _contentList = MutableLiveData<List<ContentEntity>>()
    val contentList : LiveData<List<ContentEntity>>
        get() = _contentList

    fun getContentData() = viewModelScope.launch(Dispatchers.IO) {
        _contentList.postValue(databaseRepository.getContentData())
    }

    fun insertContent(content : String) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.insertContent(content)
    }

    fun deleteSelectedContent(id : Int) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.deleteSelectedContent(id)
    }

}