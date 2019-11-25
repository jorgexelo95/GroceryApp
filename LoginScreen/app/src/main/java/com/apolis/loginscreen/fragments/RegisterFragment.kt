package com.apolis.loginscreen.fragments


import android.content.Context
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
import com.apolis.loginscreen.model.RegistrationModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        init(view)

        return view
    }

    private fun init(view: View) {
        view.button_register_submit.setOnClickListener {
            val fName = fragment_register_first_name.text.toString()
            val lName = fragment_register_last_name.text.toString()
            val pass = fragment_register_pass.text.toString()
            val email = fragment_register_email.text.toString()
            val mobile = fragment_register_mobile.text.toString()
            val register = RegistrationModel(fName, lName, email, mobile, pass)
            val shared = activity!!.getSharedPreferences("Shared", Context.MODE_PRIVATE)
            var editor = shared.edit()
            editor.putString("FIRST_NAME", fName)
            editor.putString("LAST_NAME", lName)
            editor.putString("EMAIL", email)
            editor.putString("MOBILE", mobile)
            editor.putString("PASSWORD", pass)
            editor.commit()
            createAccount(register)
        }
    }

    private fun createAccount(register: RegistrationModel) {
        progressbar.visibility = View.VISIBLE
        val url: String = "https://apolis-grocery.herokuapp.com/api/auth/register"
        var requestQueue = Volley.newRequestQueue(activity)
        var gson = Gson()
        val json = gson.toJson(register)
        val jsonObjReq = JsonObjectRequest(
            Request.Method.POST, url, JSONObject(json),
            Response.Listener {
                Toast.makeText(activity, "registered", Toast.LENGTH_SHORT).show()
                progressbar.visibility = View.GONE
            },
            Response.ErrorListener {
                Toast.makeText(activity, "Unable to create", Toast.LENGTH_SHORT).show()
                progressbar.visibility = View.GONE
            }
        )
        requestQueue.add(jsonObjReq)
    }
}
