package com.aetherized.view.pondpediaview.ui.authenticated.pond.update

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.databinding.ActivityHomeBinding
import com.aetherized.view.pondpediaview.ui.authenticated.home.HomeViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.FragmentStateAdapterAdd
import com.aetherized.view.pondpediaview.ui.authenticated.home.explore.ExploreFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.explore.FragmentStateAdapterExplore
import com.aetherized.view.pondpediaview.ui.authenticated.home.more.FragmentStateAdapterMore
import com.aetherized.view.pondpediaview.ui.authenticated.home.more.MoreFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.pond.FragmentStateAdapterPond
import com.aetherized.view.pondpediaview.ui.authenticated.home.pond.PondFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.updates.FragmentStateAdapterUpdates
import com.aetherized.view.pondpediaview.ui.authenticated.home.updates.UpdatesFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsActivity
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.main.MainActivity
import com.aetherized.view.pondpediaview.utils.helper.ReplaceListener
import com.aetherized.view.pondpediaview.utils.helper.ResetListener
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PondUpdateActivity : AppCompatActivity() , ResetListener, ReplaceListener {
    private lateinit var binding: ActivityHomeBinding


    private val viewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }

    private lateinit var toolBar: Toolbar
    private lateinit var toolbarTitle1: String
    private lateinit var toolbarTitle2: String
    private lateinit var toolbarTitle3: String
    private lateinit var toolbarTitle4: String
    private lateinit var toolbarTitle5: String
    private lateinit var toolbarTitleDetails: String

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView

    companion object {
        @StringRes
        private val TAB_TITLES_POND = intArrayOf(
            R.string.pond_tab1,
            R.string.pond_tab2,
            R.string.pond_tab3,
            R.string.pond_tab4
        )
        @StringRes
        private val TAB_TITLES_UPDATE = intArrayOf(
            R.string.updates_tab1,
            R.string.updates_tab2,
            R.string.updates_tab3,
            R.string.updates_tab4
        )
        @StringRes
        private val TAB_TITLES_ADD = intArrayOf(
            R.string.add_tab1,
            R.string.add_tab2,
            R.string.add_tab3,
            R.string.add_tab4
        )
        @StringRes
        private val TAB_TITLES_EXPLORE = intArrayOf(
            R.string.explore_tab1,
            R.string.explore_tab2,
            R.string.explore_tab3,
            R.string.explore_tab4
        )
        @StringRes
        private val TAB_TITLES_MORE = intArrayOf(
            R.string.more_tab1,
            R.string.more_tab2,
            R.string.more_tab3,
            R.string.more_tab4
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeValue()
        setupView()
        observeSettings()


    }
    private fun initializeValue(){
        toolbarTitle1 = resources.getString(R.string.title1)
        toolbarTitle2 = resources.getString(R.string.title2)
        toolbarTitle3 = resources.getString(R.string.title3)
        toolbarTitle4 = resources.getString(R.string.title4)
        toolbarTitle5 = resources.getString(R.string.title5)
        toolbarTitleDetails = "Story Details"


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

        viewPager2 = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

    }

    override fun onReplace(string: String) {
        when(string.uppercase() ) {
            "A" -> viewPager2.currentItem = 0
            "B" -> viewPager2.currentItem = 1
            "C" -> viewPager2.currentItem = 2
            "D" -> viewPager2.currentItem = 3
            else -> viewPager2.currentItem = 0
        }
    }

    override fun onReset() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE )
        settingsViewModel.getHomePageSettings().observe(this) { homepage ->
        }
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