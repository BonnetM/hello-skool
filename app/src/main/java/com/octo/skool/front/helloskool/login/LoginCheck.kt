package com.octo.skool.front.helloskool.login

class LoginCheck {

    fun check(login: String, password: String): Boolean {
        return (login.isNotEmpty() && password == "octo")
    }
}