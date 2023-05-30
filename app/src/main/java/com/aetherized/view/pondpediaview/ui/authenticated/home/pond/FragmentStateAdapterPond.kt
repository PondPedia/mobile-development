package com.aetherized.view.pondpediaview.ui.authenticated.home.pond

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentA
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentB
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentC
import com.aetherized.view.pondpediaview.ui.authenticated.home.add.AddFragmentD

class FragmentStateAdapterPond(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PondFragmentA()
            1 -> PondFragmentB()
            2 -> PondFragmentC()
            3 -> PondFragmentD()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}