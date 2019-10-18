package com.octo.skool.front.helloskool

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginPresenter = LoginPresenter(LoginCheck(), this)
        setContentView(R.layout.activity_main)
        submitButton.setOnClickListener {
            loginPresenter.handleButtonClick(login.text.toString(), password.text.toString())
        }
    }

    override fun displaySuccess(login: String) {
        Toast.makeText(this, "Bienvenue $login !", Toast.LENGTH_SHORT).show()
    }

    override fun displayError() {
        Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show()
    }

}
