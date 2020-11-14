package com.theintsuhtwe.foodforyou.delegate

import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO

interface CheckoutItemDelegate {
    fun onTapIncreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapDecreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapRemoveAddToCartItem(foodItemVO: FoodItemVO)
}