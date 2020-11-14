package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModel
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModelImpl
import com.theintsuhtwe.foodforyou.data.models.FoodModel
import com.theintsuhtwe.foodforyou.data.models.FoodModelImpl
import com.theintsuhtwe.foodforyou.mvp.views.LoginView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl
    private  val mMainModel : FoodModel = FoodModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
       mMainModel.setUpRemoteConfig()
        mMainModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(email: String, password: String) {

        mAuthenticationModel.login(email, password, onSuccess = {
            mView?.navigateToMainScreen()
        }, onFailure = {

        })
    }

    override fun onTapRegister() {
        mView?.navigateToRegisterScreen()
    }

}