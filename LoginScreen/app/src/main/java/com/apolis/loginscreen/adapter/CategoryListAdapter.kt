package com.apolis.loginscreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.apolis.loginscreen.R
import com.apolis.loginscreen.model.Product
import kotlinx.android.synthetic.main.fragment_product.view.*

class CategoryListAdapter(val context: Context, val arr: ArrayList<Product>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_product, parent, false)
        view.textView_product_name.text = arr.get(position).product
        view.textView_product_price.text = arr.get(position).price
        view.imageView_product.setImageResource(arr.get(position).img)
        return view
    }

    override fun getItem(position: Int): Any {
        return arr.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arr.size
    }
}