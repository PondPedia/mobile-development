package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.aetherized.view.pondpediaview.R
import com.google.android.material.textfield.TextInputEditText

class ExploreFragmentC : Fragment() {
    private lateinit var view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_add_c, container, false)

        return view
    }

}