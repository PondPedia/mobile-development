package com.aetherized.view.pondpediaview.ui.unauthenticated.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.data.model.LoginResult
import com.aetherized.view.pondpediaview.data.model.User
import com.aetherized.view.pondpediaview.data.remote.retrofit.ApiConfig
import com.dicoding.aetherized.aetherizedstoryappview.data.response.UserResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val pref: CustomPreference): ViewModel() {
    private val apiService = ApiConfig.getApiService()

    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: LiveData<LoginResult?> get() = _loginResult

    private val _response = MutableLiveData<UserResponse<LoginResult>>()
    val response: LiveData<UserResponse<LoginResult>> get() = _response

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    fun login(email: String, password: String, onResult: (UserResponse<LoginResult>) -> Unit) {
        viewModelScope.launch {
            try {
                val requestBody = mapOf(
                    "email" to email,
                    "password" to password
                )

                val responseTemp = apiService.login(requestBody)
                _response.postValue(responseTemp)
                responseTemp.let {
                    _loginResult.postValue(it.data)
                    _errorMessage.postValue(it.message)
                    Log.d("LoginViewModel", it.message)
                    if (it.data != null) { saveLogin(it.data) }
                    onResult(it)
                }
            } catch (exception: Exception) {
                Log.d("LoginViewModelExc", "==========FAILED========== ${exception}")
                response.value?.let { onResult(it) }
                _errorMessage.postValue("An error occurred: ${exception.message}")
            }
        }
    }
    fun loginGuest(onResult: (LoginResult)  -> Unit) {
        viewModelScope.launch {
            try {
                val guestLoginResult = LoginResult("GUEST", "GUEST", "GUEST")
                _loginResult.postValue(guestLoginResult)
                _errorMessage.postValue("lOGGED IN AS GUEST")
                Log.d("LoginViewModel", "lOGGED IN AS GUEST")
                saveLogin(guestLoginResult)
                onResult(guestLoginResult)
            } catch (exception: Exception) {
                val guestLoginResult = LoginResult("GUEST", "GUEST", "GUEST")
                Log.d("LoginViewModelExc", "==========FAILED========== ${exception}")
                onResult(guestLoginResult)
                _errorMessage.postValue("An error occurred: ${exception.message}")
            }
        }
    }

    private fun saveLogin(loginResult: LoginResult) {
        viewModelScope.launch {
            pref.saveLogin(loginResult)
        }
    }

}