package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.mvp.views.SliderView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface SliderPresenter : BasePresenter<SliderView> {
    fun onUIReady(lifecycleOwner: LifecycleOwner)
    fun onTapCreateAccount()
    fun onTapLoginButton()
}