package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.mvp.views.SliderView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class SliderPreseneterImpl: SliderPresenter , AbstractBasePresenter<SliderView>() {
    override fun onTapCreateAccount() {
        mView?.navigateToRegisterScreen()
    }

    override fun onTapLoginButton() {
        mView?.navigateToLoginScreen()
    }

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {

    }

}