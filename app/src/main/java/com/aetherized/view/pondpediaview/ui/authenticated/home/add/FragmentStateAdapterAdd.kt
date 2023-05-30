package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentStateAdapterAdd(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AddFragmentA()
            1 -> AddFragmentB()
            2 -> AddFragmentC()
            3 -> AddFragmentD()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}