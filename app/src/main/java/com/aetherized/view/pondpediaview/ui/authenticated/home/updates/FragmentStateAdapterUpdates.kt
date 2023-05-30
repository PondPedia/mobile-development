package com.aetherized.view.pondpediaview.ui.authenticated.home.updates

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentB
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentD

class FragmentStateAdapterUpdates(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UpdatesFragmentA()
            1 -> UpdatesFragmentB()
            2 -> UpdatesFragmentC()
            3 -> UpdatesFragmentD()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}