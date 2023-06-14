package com.aetherized.compose.pondpedia.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PondPediaDataStore(private val dataStore: DataStore<Preferences>) {
    private object PreferencesKeys {
        val userId = stringPreferencesKey("user_id")
        val username = stringPreferencesKey("user_name")
        val pictureUrl = stringPreferencesKey("picture_url")
        val userEmail = stringPreferencesKey("user_email")
    }

    val userDataFlow: Flow<UserData> = dataStore.data.map { preferences ->
        UserData(
            preferences[PreferencesKeys.userId] ?: "GUEST",
            preferences[PreferencesKeys.username] ?: "GUEST",
            preferences[PreferencesKeys.pictureUrl] ?: "GUEST",
            preferences[PreferencesKeys.userEmail] ?: "GUEST"
        )
    }

    suspend fun saveLogin(userData: UserData) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.userId] = userData.userId!!
            preferences[PreferencesKeys.username] = userData.username!!
            preferences[PreferencesKeys.pictureUrl] = userData.pictureUrl!!
            preferences[PreferencesKeys.userEmail] = userData.userEmail!!
        }
    }

    suspend fun clearLogin() {
        dataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.userId)
            preferences.remove(PreferencesKeys.username)
            preferences.remove(PreferencesKeys.pictureUrl)
            preferences.remove(PreferencesKeys.userEmail)
        }
    }
}