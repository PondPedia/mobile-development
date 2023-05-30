package com.aetherized.view.pondpediaview.ui.unauthenticated.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.aetherized.view.pondpediaview.data.model.User
import com.aetherized.view.pondpediaview.databinding.ActivityRegisterBinding
import com.aetherized.view.pondpediaview.ui.unauthenticated.main.MainActivity
import com.aetherized.view.pondpediaview.utils.helper.CustomPreference
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory
import java.util.regex.Pattern

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModelFactory by lazy { ViewModelFactory.getInstance(this) }
    private val viewModel by viewModels<RegisterViewModel> { viewModelFactory }


    private var nameForm = false
    private var emailForm = false
    private var passForm = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupActions()
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

    private fun setupActions() {
        binding.nameEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                nameForm = !s.isNullOrEmpty()
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
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
                if (!passForm) {
                    binding.passwordEditText.error = "Requires minimum 8 characters"
                } else {
                    binding.passwordEditText.error =  null
                }
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
        binding.signupButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            when {
                name.isEmpty() -> {
                    binding.nameEditTextLayout.error = "Masukkan email"
                }
                email.isEmpty() -> {
                    binding.emailEditTextLayout.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = "Masukkan password"
                }
                isValidPassword(password) -> {
                    binding.passwordEditTextLayout.error = "Masukkan minimal 8 karakter"
                }
                else -> {
                    val user = User(name, email.lowercase(), password, false)
                    viewModel.register(user) { response ->
                        if (!response.error) {
                            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finishAffinity()
                        } else {
                            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
    private fun setMyButtonEnable() {
        val formFilled = nameForm && emailForm && passForm
        binding.signupButton.isEnabled = formFilled
    }
    private fun isValidPassword(password: String): Boolean {
        return (password.length < 8)
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


        val login = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(500)
        val name = ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val email = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val pass = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)


        AnimatorSet().apply {
            playSequentially(name, email, pass, login)
            start()
        }
    }
}