package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.delegate.FoodItemDelegate
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.mvp.views.HomeView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface HomePresenter : BasePresenter<HomeView>, RestaurantItemDelegate, FoodItemDelegate {
    fun onUiReady(lifeCycleOwner : LifecycleOwner)


}