package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.foodforyou.data.vos.UserVO
import com.theintsuhtwe.shared.mvp.BaseView

interface ProfileView: BaseView {
    fun openGallery()
    fun displayUserProfile(user: UserVO)

}