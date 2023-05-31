package com.aetherized.view.pondpediaview.utils.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aetherized.view.pondpediaview.data.di.Injection
import com.aetherized.view.pondpediaview.data.repository.PondLogRepository
import com.aetherized.view.pondpediaview.data.repository.PondRepository
import com.aetherized.view.pondpediaview.data.repository.UpdatesRepository
import com.aetherized.view.pondpediaview.ui.authenticated.home.HomeViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.home.pond.PondViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.pond.logs.PondLogViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.main.MainViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.login.LoginViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.register.RegisterViewModel
class ViewModelFactory private constructor(
    private val pref: CustomPreference,
    private val pondRepository: PondRepository,
    private val pondLogRepository: PondLogRepository,
    private val updatesRepository: UpdatesRepository,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(pref) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(pref) as T
            }
            modelClass.isAssignableFrom(SettingsViewModel::class.java) -> {
                SettingsViewModel(pref) as T
            }
            modelClass.isAssignableFrom(PondViewModel::class.java) -> {
                PondViewModel(pref, pondRepository) as T
            }
            modelClass.isAssignableFrom(PondLogViewModel::class.java) -> {
                PondLogViewModel(pref, pondLogRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    CustomPreference.getInstance(context),
                    Injection.providePondRepository(context),
                    Injection.providePondLogRepository(context),
                    Injection.provideUpdatesRepository(context),
                )
            }.also { instance = it }
    }
}