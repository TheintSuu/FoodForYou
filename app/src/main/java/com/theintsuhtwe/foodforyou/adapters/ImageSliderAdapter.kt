package com.theintsuhtwe.foodforyou.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.theintsuhtwe.foodforyou.fragments.Page1Fragment
import com.theintsuhtwe.foodforyou.fragments.Page2Fragment
import com.theintsuhtwe.foodforyou.fragments.Page3Fragment


class ImageSliderAdapter (fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                Page1Fragment.newInstance("a", "b")}
            1 -> {
                Page2Fragment.newInstance("a", "b")}
            else -> {
                Page3Fragment.newInstance("a", "b")}
        }
    }

}