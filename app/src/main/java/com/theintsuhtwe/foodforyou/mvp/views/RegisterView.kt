package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.shared.mvp.BaseView

interface RegisterView : BaseView {
    fun navigateToToLoginScreen()

    fun showError(str : String)
}