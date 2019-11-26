package com.apolis.loginscreen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.apolis.loginscreen.fragments.ProductFragment
import com.apolis.loginscreen.model.SubCategory

class CategoryFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var titleList: ArrayList<String> = ArrayList<String>()
    var fragmentList: ArrayList<Fragment> = ArrayList<Fragment>()

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]

    }

    override fun getCount(): Int {
        return titleList.size
    }

    fun addFrag(subCategory: SubCategory) {
        fragmentList.add(ProductFragment.newInstance(subCategory.subName))
        titleList.add(subCategory.subName)
    }
}