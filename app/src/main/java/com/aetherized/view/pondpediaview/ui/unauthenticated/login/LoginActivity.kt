package com.aetherized.view.pondpediaview.ui.unauthenticated.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContentProviderCompat.requireContext
import com.aetherized.view.pondpediaview.databinding.ActivityLoginBinding
import com.aetherized.view.pondpediaview.ui.authenticated.home.HomeActivity
import com.aetherized.view.pondpediaview.ui.authenticated.settings.SettingsViewModel
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }
    private val settingsViewModel by viewModels<SettingsViewModel> { viewModelFactory }

    private var emailForm = false
    private var passForm = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        observeSettings()
        observeViewModel()
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

    private fun observeSettings() {
        settingsViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(this) {
            Log.d("LoginActivity", "loginResult: $it")
        }
        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAction() {
        binding.emailEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailForm = isValidEmail(s.toString())
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
        binding.passwordEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passForm = isValidPassword(s.toString())
                if (passForm) {
                    Log.d("PasswordLoginActivity", "passForm: ${passForm}, count: $count Text: ${s.toString()}")
                    binding.passwordEditText.error = null
                } else {
                    Log.d("PasswordLoginActivity", "passForm: ${passForm}, count: $count Text: ${s.toString()}")
                    binding.passwordEditText.error =  "Requires minimum 8 characters"
                }
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().lowercase()
            val password = binding.passwordEditText.text.toString()

            when {
                email.isEmpty() -> {
                    binding.emailEditTextLayout.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = "Masukkan password"
                }
                else -> {
                    viewModel.login(email, password) { response ->
                        if (!response.error) {
                            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        binding.loginGuestButton.setOnClickListener {
            viewModel.loginGuest {
                Toast.makeText(this, "LOGGED IN AS GUEST", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
    }

    private fun setMyButtonEnable() {
        val formFilled = emailForm && passForm
        binding.loginButton.isEnabled = formFilled
    }
    private fun isValidPassword(password: String): Boolean {
        return (password.length > 7)
    }
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$"
        val pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
    private fun playAnimation() {
        val translationAnimator = ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -60f, 60f).apply {
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

        AnimatorSet().apply {
            playTogether(translationAnimator, rotateCounterClockwise, rotateClockwise)
            start()
        }


        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val loginGuest = ObjectAnimator.ofFloat(binding.loginGuestButton, View.ALPHA, 1f).setDuration(500)
        val email = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val pass = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)


        AnimatorSet().apply {
            playSequentially(email, pass, login, loginGuest)
            start()
        }
    }
}