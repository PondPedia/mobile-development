package com.aetherized.view.pondpediaview.ui.authenticated.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentB
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import androidx.lifecycle.Lifecycle

class SectionsPagerAdapter internal constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AddFragmentA()
            1 -> AddFragmentB()
            2 -> AddFragmentC()
            4 -> AddFragmentA()
            else -> AddFragmentA()
        }
    }
}