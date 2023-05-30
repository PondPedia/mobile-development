package com.aetherized.view.pondpediaview.ui.authenticated.home.pond.details.logs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.local.entity.PondLogEntity
import com.aetherized.view.pondpediaview.data.repository.PondLogRepository
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference

class PondLogViewModel (private val pref: CustomPreference, val repository: PondLogRepository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage



    init {
        _isLoading.postValue(true)
    }

    fun getAllPondLogs(): LiveData<List<PondLogEntity>> {
        _isLoading.postValue(false)
        return repository.allPondLogs
    }

    suspend fun insertPondLog(pondLog: PondLogEntity): Long {
        return repository.insertPondLog(pondLog)
    }

}