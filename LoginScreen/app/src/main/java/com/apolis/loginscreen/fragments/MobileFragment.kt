package com.apolis.loginscreen.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolis.loginscreen.R
import com.apolis.loginscreen.adapter.CategoryRecycleViewAdapter
import com.apolis.loginscreen.model.Product
import kotlinx.android.synthetic.main.fragment_common.view.*

/**
 * A simple [Fragment] subclass.
 */
class MobileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_common, container, false)
        var flag = false

        var phoneList = arrayListOf<Product>()
        phoneList.add(Product("iPhone", "$100", R.drawable.mobilephone))
        phoneList.add(Product("iPhone2", "$200", R.drawable.mobile2))
        phoneList.add(Product("iPhone3", "$300", R.drawable.mobile3))
        phoneList.add(Product("iPhone4", "$400", R.drawable.mobile4))
        phoneList.add(Product("iPhone5", "$500", R.drawable.mobile5))

        //var adapter = CategoryListAdapter(activity!!, phoneList)
        //view.listView.adapter = adapter

        val adapter = CategoryRecycleViewAdapter(activity!!, phoneList)
        view.recycler_view.layoutManager = LinearLayoutManager(activity!!)
        view.recycler_view.adapter = adapter

        view.button_switch.setOnClickListener {
            when (flag) {
                false -> {
                    view.recycler_view.layoutManager = GridLayoutManager(activity!!, 2)
                    flag = true
                }
                else -> {
                    view.recycler_view.layoutManager = LinearLayoutManager(activity!!)
                    flag = false
                }
            }
        }

        return view
    }


}
