package com.octo.skool.front.helloskool.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.octo.skool.front.helloskool.R
import com.octo.skool.front.helloskool.main.ResultActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginPresenter = LoginPresenter(
            LoginCheck(),
            this
        )
        setContentView(R.layout.activity_login)
        submitButton.setOnClickListener {
            loginPresenter.handleButtonClick(login.text.toString(), password.text.toString())
        }
    }

    override fun displaySuccess(login: String) {
        Toast.makeText(this, "Bienvenue $login !", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, ResultActivity::class.java))
    }

    override fun displayError() {
        Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show()
    }
}