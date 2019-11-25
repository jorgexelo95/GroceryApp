package com.apolis.loginscreen.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.loginscreen.R
import com.apolis.loginscreen.model.Product
import kotlinx.android.synthetic.main.activity_main_cart.view.*
import kotlinx.android.synthetic.main.fragment_product.view.*

class CategoryRecycleViewAdapter(var context: Context, var productList: ArrayList<Product>) :
    RecyclerView.Adapter<CategoryRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_product, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products = productList.get(position)
        holder.bindProduct(products)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindProduct(products: Product) {
            var textViewName = itemView.textView_product_name
            var textViewPrice = itemView.textView_product_price
            var imageView = itemView.imageView_product

            textViewName.text = products.product
            textViewPrice.text = products.price
            imageView.setImageResource(products.img)

            itemView.button_addToCart.setOnClickListener {
                itemView.button_addToCart.visibility = View.GONE
                itemView.linearlayout_buttons.visibility = View.VISIBLE
            }
            itemView.button_add.setOnClickListener {
                itemView.textView_quantity.text =
                    (itemView.textView_quantity.text.toString().toInt() + 1).toString()
            }
            itemView.button_minus.setOnClickListener {
                if (itemView.textView_quantity.text.toString().toInt() == 0) {
                } else itemView.textView_quantity.text =
                    (itemView.textView_quantity.text.toString().toInt() - 1).toString()
            }
            itemView.button_delete.setOnClickListener {
                productList.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

}