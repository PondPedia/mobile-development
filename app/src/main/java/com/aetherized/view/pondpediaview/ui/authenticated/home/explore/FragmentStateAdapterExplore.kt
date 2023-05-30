package com.aetherized.view.pondpediaview.ui.authenticated.home.explore

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentB
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentD
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.ExploreFragmentC

class FragmentStateAdapterExplore(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ExploreFragmentA()
            1 -> ExploreFragmentB()
            2 -> ExploreFragmentC()
            3 -> ExploreFragmentD()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}