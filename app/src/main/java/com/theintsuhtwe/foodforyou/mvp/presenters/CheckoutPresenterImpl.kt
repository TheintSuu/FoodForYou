package com.theintsuhtwe.foodforyou.mvp.presenters

import android.content.Context
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.CheckoutItemDelegate
import com.theintsuhtwe.foodforyou.mvp.views.CheckoutView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter
import com.theintsuhtwe.shared.mvp.presenter.BasePresenter

class  CheckoutPresenterImpl : CheckoutPresenter, AbstractBasePresenter<CheckoutView>() {
    override fun onTapCheckout(context: Context, orderList: List<FoodItemVO>) {
        TODO("Not yet implemented")
    }

    override fun onTapIncreaseAddToCartItem(foodItemVO: FoodItemVO) {
        TODO("Not yet implemented")
    }

    override fun onTapDecreaseAddToCartItem(foodItemVO: FoodItemVO) {
        TODO("Not yet implemented")
    }

    override fun onTapRemoveAddToCartItem(foodItemVO: FoodItemVO) {
        TODO("Not yet implemented")
    }


}