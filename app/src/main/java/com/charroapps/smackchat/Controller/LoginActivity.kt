package com.charroapps.smackchat.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.charroapps.smackchat.R
import com.charroapps.smackchat.Services.AuthService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginCreateUserClicked(view : View){
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }

    fun loginLoginUserClicked(view: View){
        val email = loginEmailTxt.text.toString()
        val password = loginPassTxt.text.toString()

        AuthService.loginUser(this, email, password){ loginSuccess ->
            if(loginSuccess){
                AuthService.findUserbyEmail(this){ findSuccess ->
                    if(findSuccess){
                        finish()
                    }
                }
            }

        }
    }
}
