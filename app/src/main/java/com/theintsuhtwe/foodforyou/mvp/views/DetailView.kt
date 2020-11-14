package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.shared.mvp.BaseView

interface DetailView : BaseView {
    fun displayRestaurant(shopVO: ShopVO)
    fun displayPopularFood(popularFoodList: List<FoodItemVO>)
    fun displayFoodItemList(foodList: List<FoodItemVO>)
    fun displayCartCount(cartCount : Long)
}