package com.project.imagesearch.widget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.imagesearch.main.ImageSearchFragment

class SectionsPagerAdapter(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return ImageSearchFragment()
    }

    override fun getItemCount(): Int {
        return 2
    }
}