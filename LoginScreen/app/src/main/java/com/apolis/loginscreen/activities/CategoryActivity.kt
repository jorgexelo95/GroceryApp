package com.apolis.loginscreen.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.apolis.loginscreen.R
import com.apolis.loginscreen.adapter.CategoryAdapter
import com.apolis.loginscreen.model.Category
import com.apolis.loginscreen.model.CategoryList
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    var adapter: CategoryAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        init()
        getCategory()

    }

    private fun init() {
        var list = ArrayList<Category>()
        category_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = CategoryAdapter(this, list)
        category_recycler_view.adapter = adapter
    }

    private fun getCategory(){
        val url: String = "https://apolis-grocery.herokuapp.com/api/category"
        var requestQueue = Volley.newRequestQueue(this)
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener { response ->
                var data = response.toString()
                var gson = GsonBuilder().create()
                var categoryList: CategoryList =  gson.fromJson(data, CategoryList::class.java)

                adapter?.setData(categoryList.data)

                progress_bar.visibility = View.GONE


            },
            Response.ErrorListener {
                Log.e("jay", it.message)
            })
        requestQueue.add(stringRequest)
    }
}
