package com.octo.skool.front.helloskool.login

import android.content.SharedPreferences

class LoginCache(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        private const val LOGIN_PREFRENCES_KEY = "SKOOL_LOGIN"
    }

    fun storeLogin(login: String) {
        sharedPreferences.edit()
            .putString(LOGIN_PREFRENCES_KEY, login)
            .apply()
    }

    fun removeStoredLogin() {
        sharedPreferences.edit()
            .remove(LOGIN_PREFRENCES_KEY)
            .apply()
    }

    fun retrieveLogin() : String?{
        return sharedPreferences.getString(LOGIN_PREFRENCES_KEY, null)
    }
}