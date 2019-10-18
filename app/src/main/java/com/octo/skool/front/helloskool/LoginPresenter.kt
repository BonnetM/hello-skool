package com.octo.skool.front.helloskool

interface LoginView {
    fun displaySuccess(login: String)
    fun displayError()
}

class LoginPresenter(
    private val loginCheck: LoginCheck,
    private val loginView: LoginView
) {

    fun handleButtonClick(login: String, password: String) {
        if(loginCheck.check(login, password)){
            loginView.displaySuccess(login)
        } else {
            loginView.displayError()
        }
    }

}