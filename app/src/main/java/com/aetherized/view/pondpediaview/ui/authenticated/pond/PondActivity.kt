package com.aetherized.view.pondpediaview.ui.authenticated.pond

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.FragmentManager
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.databinding.ActivityHomeBinding
import com.aetherized.view.pondpediaview.ui.authenticated.home.HomeViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsActivity
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.main.MainActivity
import com.aetherized.view.pondpediaview.utils.helper.ReplaceListener
import com.aetherized.view.pondpediaview.utils.helper.ResetListener
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PondActivity : AppCompatActivity(), ResetListener {
    private lateinit var binding: ActivityHomeBinding

    private val viewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }

    private lateinit var toolBar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeValue()
        setupView()
        observeSettings()
    }

    private fun initializeValue(){

    }
    private fun observeSettings() {

        settingsViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
    private fun setupView(){
        toolBar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)
    }

    override fun onReset() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE )
    }

    private fun replaceToolbar(title: String) {
        toolBar.title = title
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.action_logout -> {
                settingsViewModel.logout()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}