package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.mvp.presenters.DetailPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.presenters.LoginPresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.LoginPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.LoginView
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() , LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpActionListeners()

        mPresenter.onUIReady(this)
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(etEmail.text.toString(), etPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
        this.finish()
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

}