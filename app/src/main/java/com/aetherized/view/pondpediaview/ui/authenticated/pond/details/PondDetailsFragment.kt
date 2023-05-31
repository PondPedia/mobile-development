package com.aetherized.view.pondpediaview.ui.authenticated.pond.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.model.User
import com.google.android.material.tabs.TabLayout

class PondDetailsFragment : Fragment() {


    private lateinit var login: String
    private lateinit var view: View
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var favoriteButton: Button
    private lateinit var pond: PondEntity

//    private lateinit var detailsViewModel: DetailsViewModel

    private var msg = "NONE"


//    companion object {
//        @StringRes
//        private val TAB_TITLES = intArrayOf(
//            R.string.tab3,
//            R.string.tab0,
//            R.string.tab1
//        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pond_details, container, false)
    }

}