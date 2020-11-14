package com.theintsuhtwe.foodforyou.delegate

import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO

interface FoodItemDelegate {
    fun onTapFoodItem(item : FoodItemVO)
}