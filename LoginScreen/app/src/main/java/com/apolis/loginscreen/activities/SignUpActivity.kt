package com.apolis.loginscreen.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apolis.loginscreen.R
import com.apolis.loginscreen.adapter.MyFragmentAdapter
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var flag =
            getSharedPreferences("Shared", Context.MODE_PRIVATE).getBoolean("LOGIN",false)
        when(flag){
            false ->{
                var fragment = MyFragmentAdapter(supportFragmentManager)
                viewPager.adapter = fragment
                tabLayout.setupWithViewPager(viewPager)
            }
            true ->{
                var intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
