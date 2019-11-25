package com.apolis.loginscreen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.apolis.loginscreen.fragments.LogInFragment
import com.apolis.loginscreen.fragments.RegisterFragment

class MyFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> {
                RegisterFragment()
            }
            else -> {
                LogInFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            1 -> {
                "Register"
            }
            else -> {
                "Log In"
            }
        }
    }
}