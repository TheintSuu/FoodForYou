package com.theintsuhtwe.foodforyou.mvp.views

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.shared.mvp.BaseView

interface SliderView : BaseView {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()


}