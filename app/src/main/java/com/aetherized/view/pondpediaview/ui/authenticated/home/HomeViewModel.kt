package com.aetherized.view.pondpediaview.ui.authenticated.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.data.model.LoginResult
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiConfig
import com.dicoding.aetherized.aetherizedstoryappview.data.response.UserResponse

class  HomeViewModel(private val pref: CustomPreference) : ViewModel() {
    private val apiService = ApiConfig.getApiService()

    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: LiveData<LoginResult?> get() = _loginResult

    private val _response = MutableLiveData<UserResponse<LoginResult>>()
    val response: LiveData<UserResponse<LoginResult>> get() = _response

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
    }


}