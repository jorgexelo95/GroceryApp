package com.apolis.loginscreen.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.apolis.loginscreen.adapter.CategoryFragmentAdapter
import com.apolis.loginscreen.adapter.CategoryListAdapter
import com.apolis.loginscreen.model.Product
import com.apolis.loginscreen.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main_cart.*
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_common.*

class MainActivityCart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cart)
        var fragment = CategoryFragmentAdapter(supportFragmentManager)
        viewPager.adapter = fragment
        tabLayout.setupWithViewPager(viewPager)
        button_cart_logout.setOnClickListener {
            var shared = getSharedPreferences("Shared", Context.MODE_PRIVATE).edit().putBoolean("LOGIN", false).commit()
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
            finish()
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cart, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_cart ->{
                Toast.makeText(applicationContext, "Cart", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_profile ->{
                Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
