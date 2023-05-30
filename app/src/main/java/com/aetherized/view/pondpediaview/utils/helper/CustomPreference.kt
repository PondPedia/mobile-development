package com.aetherized.view.pondpediaview.utils.helper

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aetherized.view.pondpediaview.data.model.LoginResult
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_preferences")

class CustomPreference private constructor(context: Context) {
    private val dataStore = context.dataStore
    private val gson = Gson()

    private val loginResultKey = stringPreferencesKey(Constants.PREF_LOGIN)
    private val themeKey = booleanPreferencesKey(Constants.PREFS_KEY_THEME)
    private val homePageKey = stringPreferencesKey(Constants.PREFS_KEY_HOMEPAGE)

    private val _prefDarkMode = MutableLiveData<Boolean>()
    val prefDarkMode: LiveData<Boolean> get() = _prefDarkMode

    val loginResultFlow: Flow<LoginResult?> = dataStore.data.map { preferences ->
        val loginResultJson = preferences[loginResultKey]
        if (loginResultJson != null) {
            gson.fromJson(loginResultJson, LoginResult::class.java)
        } else {
            null
        }
    }

    suspend fun saveLogin(loginResult: LoginResult) {
        val loginResultJson = gson.toJson(loginResult)
        dataStore.edit { preferences ->
            preferences[loginResultKey] = loginResultJson
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences[loginResultKey] = ""
        }
    }

    fun getThemeSetting(): LiveData<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[themeKey] ?: false
        }.asLiveData()
    }

    suspend fun saveThemeSetting(isDarkModeActive: Boolean) {
        dataStore.edit { preferences ->
            preferences[themeKey] = isDarkModeActive
        }
    }

    fun getHomePageSetting(): LiveData<String> {
        return dataStore.data.map { preferences ->
            preferences[homePageKey] ?: "Ponds"
        }.asLiveData()
    }

    suspend fun saveHomePageSetting(homepage: String) {
        dataStore.edit { preferences ->
            preferences[homePageKey] = homepage
        }
    }

    companion object {
        @Volatile
        private var instance: CustomPreference? = null

        fun getInstance(context: Context): CustomPreference {
            return instance ?: synchronized(this) {
                instance ?: CustomPreference(context).also { instance = it }
            }
        }
    }
}

