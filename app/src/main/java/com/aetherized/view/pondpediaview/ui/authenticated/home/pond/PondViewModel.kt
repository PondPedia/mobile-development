package com.aetherized.view.pondpediaview.ui.authenticated.home.pond

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.repository.PondRepository
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference

class PondViewModel(private val pref: CustomPreference, val repository: PondRepository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        _isLoading.postValue(true)
    }

    fun getAllPonds(): LiveData<List<PondEntity>> {
        _isLoading.postValue(false)
        return repository.allPonds
    }

    suspend fun insertPond(pond: PondEntity): Long {
        return repository.insertPond(pond)
    }

    suspend fun updatePond(pond: PondEntity) {
        repository.updatePond(pond)
    }
}