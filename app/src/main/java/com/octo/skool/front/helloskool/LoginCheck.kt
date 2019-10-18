package com.octo.skool.front.helloskool

class LoginCheck {

    fun check(login: String, password: String): Boolean {
        return (login.isNotEmpty() && password == "octo")
    }
}