package com.theintsuhtwe.foodforyou.delegate

import com.theintsuhtwe.foodforyou.data.vos.ShopVO

interface RestaurantItemDelegate {
    fun onTapRestaurant(rest : ShopVO)
}