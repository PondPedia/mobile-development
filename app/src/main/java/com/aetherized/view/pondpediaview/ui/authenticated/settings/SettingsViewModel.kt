package com.aetherized.view.pondpediaview.ui.authenticated.settings

import androidx.lifecycle.*
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.data.model.LoginResult
import kotlinx.coroutines.launch

//private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsViewModel (private val pref: CustomPreference) : ViewModel() {
    private val _prefDarkMode = MutableLiveData<Boolean>()
    val prefDarkMode: LiveData<Boolean> get() = _prefDarkMode

    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: LiveData<LoginResult?> get() = _loginResult


    val loginResultLiveData = pref.loginResultFlow.asLiveData()


    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting()
    }

    fun saveThemeSetting(isDarkMode: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkMode)
        }
    }

    fun getHomePageSettings(): LiveData<String> {
        return pref.getHomePageSetting()
    }

    fun saveHomePageSetting(homepage: String) {
        viewModelScope.launch {
            pref.saveHomePageSetting(homepage)
        }
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}