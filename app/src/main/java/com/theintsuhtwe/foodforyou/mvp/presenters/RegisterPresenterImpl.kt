package com.theintsuhtwe.foodforyou.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModel
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModelImpl
import com.theintsuhtwe.foodforyou.mvp.views.RegisterView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister( username: String, email: String, password: String, phone : String) {

        mAuthenticationModel.register(username, email, password,phone, onSuccess = {
            mView?.navigateToToLoginScreen()
        }, onFailure = {
            mView?.showError(it)
        })
    }


    override fun navigateToLoginScreen() {
        mView?.navigateToToLoginScreen()
    }


}