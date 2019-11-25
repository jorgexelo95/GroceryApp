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
class LaptopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_common, container, false)
        var flag = false
        var lapList = ArrayList<Product>()
        lapList.add(Product("Laptop1", "$100", R.drawable.laptop1))
        lapList.add(Product("Laptop2", "$200", R.drawable.laptop2))
        lapList.add(Product("Laptop3", "$300", R.drawable.laptop3))
        lapList.add(Product("Laptop4", "$400", R.drawable.laptop4))
        lapList.add(Product("Laptop5", "$500", R.drawable.laptop5))

        //var adapter = CategoryListAdapter(activity!!, lapList)
        //view.listView.adapter = adapter

        val adapter = CategoryRecycleViewAdapter(activity!!, lapList)
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
