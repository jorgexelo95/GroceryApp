package com.apolis.loginscreen.fragments


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.apolis.loginscreen.R
import com.apolis.loginscreen.activities.MainActivityCart
import com.apolis.loginscreen.model.LogInResponse
import com.apolis.loginscreen.model.LoginModel
import com.apolis.loginscreen.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_log_in.view.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class LogInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_log_in, container, false)
        var shared = activity!!.getSharedPreferences("Shared", Context.MODE_PRIVATE)

        init(view, shared)
        return view
    }

    private fun init(view: View, shared: SharedPreferences) {
        view.button_login_submit.setOnClickListener {
            var email = fragment_login_email.text.toString()
            var pass = fragment_login_pass.text.toString()
            val loginAcc = LoginModel(email, pass)
            loginAccount(loginAcc, shared)
        }


//            if (view.fragment_login_user.text.toString() == email || view.fragment_login_pass.text.toString() == pass) {
//                shared.edit().putBoolean("LOGIN", true).commit()
//            }
//            var status = shared.getBoolean("LOGIN", false)
//            when (status) {
//                true -> {
//                    Toast.makeText(context, "LOGGIN IN", Toast.LENGTH_SHORT).show()
//                    var intent = Intent(activity, MainActivityCart::class.java)
//                    startActivity(intent)
//                }
//                else -> Toast.makeText(context, "ACCOUNT NOT REGISTERED", Toast.LENGTH_SHORT).show()
//
//            }
//        view.button_logout.setOnClickListener {
//            shared.edit().putBoolean("LOGIN", false).commit()
//            Toast.makeText(context, "LOGGIN OUT", Toast.LENGTH_SHORT).show()
//        }
    }

    private fun loginAccount(loginAcc: LoginModel, shared: SharedPreferences) {
        //progressbar.visibility = View.VISIBLE

        val url: String = "https://apolis-grocery.herokuapp.com/api/auth/login"
        var requestQueue = Volley.newRequestQueue(activity)
        var gson = Gson()
        var json = gson.toJson(loginAcc)
        val jsonObj = JsonObjectRequest(Request.Method.POST, url, JSONObject(json),
            Response.Listener { response ->
                //                shared.edit().putBoolean("LOGIN", true).commit()
                // Toast.makeText(activity, "LOGGING IN"+response.toString(), Toast.LENGTH_SHORT).show()
                //response.getBoolean("error")
                var gson2 = GsonBuilder().create()
                val loginResponse: LogInResponse = gson2.fromJson(response.toString(), LogInResponse::class.java)
                Toast.makeText(activity, "${loginResponse.user.email}", Toast.LENGTH_SHORT).show()
                //progressbar.visibility = View.GONE
               //startActivity(Intent(activity, MainActivityCart::class.java))
            },
            Response.ErrorListener {
                Toast.makeText(activity, "Log in unsuccessful", Toast.LENGTH_SHORT).show()
                progressbar.visibility = View.GONE
            })
        requestQueue.add(jsonObj)
    }
// implement splash screen or start activity which includes logo + name & button (goes to login/register activity)
// option bar -> always appear cart icon,
}




