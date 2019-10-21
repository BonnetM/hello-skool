package com.octo.skool.front.helloskool.login

interface LoginView {
    fun displaySuccess(login: String)
    fun displayError()
    fun fillLogin(login: String)
}

class LoginPresenter(
    private val loginCheck: LoginCheck,
    private val loginView: LoginView,
    private val loginCache: LoginCache
) {

    fun load() {
        loginCache.retrieveLogin()?.let(loginView::fillLogin)
    }

    fun handleButtonClick(login: String, password: String, shouldSaveLogin: Boolean) {
        if (loginCheck.check(login, password)) {
            if (shouldSaveLogin) {
                loginCache.storeLogin(login)
            } else {
                loginCache.removeStoredLogin()
            }
            loginView.displaySuccess(login)
        } else {
            loginView.displayError()
        }
    }
}