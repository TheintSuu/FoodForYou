package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.shared.mvp.BaseView

interface CheckoutView : BaseView {
    fun displayOrderList(orderList: List<FoodItemVO>)
    fun displayTotalAmount(totalAmount: Long)

}