package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.mvp.presenters.LoginPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.presenters.RegisterPresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.RegisterPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.RegisterView
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() , RegisterView {

    private lateinit var mPresenter: RegisterPresenter


    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpPresenter()
        setUpActionListeners()
    }


    private fun setUpActionListeners() {
        btnRegister.setOnClickListener {
            mPresenter.onTapRegister(
                etUserName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etPhone.text.toString()
            )
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        this.finish()
    }

    override fun showError(str: String) {
       Toast.makeText(this, str, Toast.LENGTH_LONG)
    }
}