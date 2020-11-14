package com.theintsuhtwe.foodforyou.mvp.presenters

import android.content.Context
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.CheckoutItemDelegate
import com.theintsuhtwe.foodforyou.mvp.views.CheckoutView
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

interface CheckoutPresenter : BasePresenter<CheckoutView>, CheckoutItemDelegate {

    fun onTapCheckout(context: Context, orderList: List<FoodItemVO>)

}