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
class DesktopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_common, container, false)
        var flag = false

        var deskList = ArrayList<Product>()
        deskList.add(Product("Desktop 1", "$100", R.drawable.dektophp))
        deskList.add(Product("Desktop 2", "$200", R.drawable.desktop2))
        deskList.add(Product("Desktop 3", "$300", R.drawable.desktop3))
        deskList.add(Product("Desktop 4", "$400", R.drawable.desktop4))
        deskList.add(Product("Desktop 5", "$500", R.drawable.desktop5))

        //var adapter = CategoryListAdapter(activity!!, deskList)
        //view.listView.adapter = adapter

        val adapter = CategoryRecycleViewAdapter(activity!!, deskList)
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
