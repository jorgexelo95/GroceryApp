package com.apolis.loginscreen.helpers

import android.content.Context
import android.content.SharedPreferences
import com.apolis.loginscreen.model.User

class SessionManager(var context: Context) {

    var sharedPreferences: SharedPreferences
    var editor: SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    companion object {
        const val FILE_NAME: String = "myPref"
        const val FIRST_NAME: String = "first_name"
        const val LAST_NAME: String = "last_name"
        const val IS_LOGIN: String = "is_login"
    }

    fun createUser(User: User) {
        editor.putString(FIRST_NAME, User.firstName)
        editor.putString(LAST_NAME, User.lastName)
        editor.putBoolean(IS_LOGIN, true)
        editor.commit()
    }

    fun isLogin(): Boolean {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    fun logout() {
        sharedPreferences.edit().clear()
    }


}