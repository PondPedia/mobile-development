package com.aetherized.view.pondpediaview.ui.authenticated.settings.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory
import com.google.android.material.switchmaterial.SwitchMaterial

private val Context.dataStore by preferencesDataStore(name = "settings")
class SettingsFragment : Fragment() {
    private lateinit var switchTheme: SwitchMaterial
    private val viewModelFactory by lazy { ViewModelFactory.getInstance(requireContext()) }
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        switchTheme = view.findViewById(R.id.switch_theme)

//        val pref = UserPreference.getInstance(requireContext().dataStore)

        settingsViewModel.getThemeSettings()
            .observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    switchTheme.isChecked = true
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    switchTheme.isChecked = false
                }


                switchTheme.setOnCheckedChangeListener { _, isChecked ->
                    settingsViewModel.saveThemeSetting(isChecked)
                }
            }
        return view
    }
}