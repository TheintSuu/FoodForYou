package com.theintsuhtwe.foodforyou.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.delegate.DetailFoodItemDelegate
import com.theintsuhtwe.foodforyou.mvp.views.DetailView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface DetailPresenter : BasePresenter<DetailView>,
      DetailFoodItemDelegate{

    fun onUiReady(shopId: String,lifecycleOwner: LifecycleOwner)

    fun onTapFoodIteToCart()

}