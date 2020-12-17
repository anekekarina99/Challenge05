package com.android.rockscich5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class LandPageAdpt (fm : FragmentManager) : FragmentPagerAdapter(fm){

    private val pages = listOf(
        LpOne(),
        LpTwoFrag(),
        LpThreeFragNew()
    )
    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }


}
