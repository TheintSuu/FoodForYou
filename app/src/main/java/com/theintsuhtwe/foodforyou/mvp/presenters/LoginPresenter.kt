package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.mvp.views.LoginView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onUIReady(lifecycleOwner: LifecycleOwner)
    fun onTapLogin(email:String, password:String)
    fun onTapRegister()

}