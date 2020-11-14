package com.theintsuhtwe.foodforyou.mvp.presenters

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.mvp.views.ProfileView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface ProfilePresenter : BasePresenter<ProfileView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onTapUpdateProfile()
    fun updateUserProfile(bitmap: Bitmap)


}