package com.theintsuhtwe.foodforyou.mvp.presenters

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModel
import com.theintsuhtwe.foodforyou.data.models.AuthenticationModelImpl
import com.theintsuhtwe.foodforyou.mvp.views.ProfileView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mAuthModel: AuthenticationModel = AuthenticationModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView?.displayUserProfile(mAuthModel.getUserProfile())

    }

    override fun onTapUpdateProfile() {
        mView?.openGallery()
    }

    override fun updateUserProfile(bitmap: Bitmap) {
        mAuthModel.uploadPhotoUrl(bitmap,
                onSuccess = {
                    mAuthModel.updateProfile(it, onSuccess = {

                    }) {errorMsg ->
                        Log.d("hello preset", errorMsg)
                    }
                },
                onFailure = {
                Log.d("hello preset", it)
                })
    }


}


