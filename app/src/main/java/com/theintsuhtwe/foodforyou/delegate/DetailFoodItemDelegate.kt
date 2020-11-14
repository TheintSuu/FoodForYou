package com.theintsuhtwe.foodforyou.delegate

import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO

interface DetailFoodItemDelegate {
    fun onTapFoodItemToCart(item : FoodItemVO)
}