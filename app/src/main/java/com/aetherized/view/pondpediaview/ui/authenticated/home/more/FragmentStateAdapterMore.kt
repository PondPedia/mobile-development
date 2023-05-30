package com.aetherized.view.pondpediaview.ui.authenticated.home.more

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentB
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentD

class FragmentStateAdapterMore(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoreFragmentA()
            1 -> MoreFragmentB()
            2 -> MoreFragmentC()
            3 -> MoreFragmentD()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}