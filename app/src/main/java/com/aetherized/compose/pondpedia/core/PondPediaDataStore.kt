package com.aetherized.compose.pondpedia.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PondPediaDataStore(private val dataStore: DataStore<Preferences>) {
    private object PreferencesKeys {
        val userId = stringPreferencesKey("user_id")
        val name = stringPreferencesKey("name")
        val token = stringPreferencesKey("token")
    }

//    val loginResultFlow: Flow<LoginResult> = dataStore.data.map { preferences ->
//        LoginResult(
//            preferences[PreferencesKeys.userId] ?: "GUEST",
//            preferences[PreferencesKeys.name] ?: "GUEST",
//            preferences[PreferencesKeys.token] ?: "GUEST"
//        )
//    }
//
//    suspend fun saveLogin(loginResult: LoginResult) {
//        dataStore.edit { preferences ->
//            preferences[PreferencesKeys.userId] = loginResult.userId
//            preferences[PreferencesKeys.name] = loginResult.name
//            preferences[PreferencesKeys.token] = loginResult.token
//        }
//    }

    suspend fun clearLogin() {
        dataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.userId)
            preferences.remove(PreferencesKeys.name)
            preferences.remove(PreferencesKeys.token)
        }
    }
}