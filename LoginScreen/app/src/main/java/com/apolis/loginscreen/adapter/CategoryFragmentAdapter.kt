package com.apolis.loginscreen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.apolis.loginscreen.fragments.DesktopFragment
import com.apolis.loginscreen.fragments.LaptopFragment
import com.apolis.loginscreen.fragments.MobileFragment

class CategoryFragmentAdapter(fm: FragmentManager):FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Mobile"
            1 -> "Laptop"
            else -> "Desktop"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MobileFragment()
            1 -> LaptopFragment()
            else -> DesktopFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}