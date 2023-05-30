package com.aetherized.view.pondpediaview.ui.unauthenticated.main

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.aetherized.view.pondpediaview.databinding.ActivityMainBinding
import com.aetherized.view.pondpediaview.ui.authenticated.home.HomeActivity
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.ui.unauthenticated.login.LoginActivity
import com.aetherized.view.pondpediaview.ui.unauthenticated.register.RegisterActivity
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingsViewModel.loginResultLiveData.observe(this) { loginResult ->
            Log.d("MainActivityLoggedCheck", "$loginResult | ${loginResult?.token}")
            if (loginResult != null) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
        
        setupView()
        setupAction()
        playAnimation()

    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.signupButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun playAnimation() {
        val logoIV = ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -60f, 60f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }

        val rotateClockwise = ObjectAnimator.ofFloat(binding.imageView, View.ROTATION, 0f, 40f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }

        val rotateCounterClockwise = ObjectAnimator.ofFloat(binding.imageView, View.ROTATION, 0f, -40f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }

        val bubbleIV = ObjectAnimator.ofFloat(binding.bubbleView, View.TRANSLATION_Y, 400f, -400f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
        }

        AnimatorSet().apply {
            playTogether(logoIV, rotateCounterClockwise, rotateClockwise)
            play(bubbleIV)
            start()
        }


        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(500)
        val title = ObjectAnimator.ofFloat(binding.titleTextView,View.ALPHA, 1f).setDuration(500)
        val desc = ObjectAnimator.ofFloat(binding.descTextView, View.ALPHA, 1f).setDuration(500)

        val together = AnimatorSet().apply {
            playTogether(login, signup)
        }

        AnimatorSet().apply {
            playSequentially(title, desc, together)
            start()
        }
    }
}