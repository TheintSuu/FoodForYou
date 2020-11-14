package com.theintsuhtwe.foodforyou.mvp.presenters

import android.content.Context
import com.theintsuhtwe.foodforyou.mvp.views.RegisterView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister( username: String, email: String, password: String, phone : String)
    fun navigateToLoginScreen()
}