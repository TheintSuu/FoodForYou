package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.shared.mvp.BaseView

interface LoginView : BaseView {
    fun navigateToRegisterScreen()

    fun navigateToMainScreen()

}