package com.theintsuhtwe.foodforyou.data.models

import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.network.FirebaseApi
import com.theintsuhtwe.foodforyou.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodModel {
    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getRestaurants(onSuccess: (List<ShopVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getAllFoodItemsByShop(shopId: String, onSuccess: (List<FoodItemVO>, ShopVO) -> Unit, onFaiure: (String) -> Unit)

    fun getPopularFoodItems( onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getTotalFoodItemCount(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit)

    fun getTotalPrice(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit)

    fun addFoodItem(item : FoodItemVO)

    fun setUpRemoteConfig()

    fun fetchRemoteConfigs()

    fun getHomeScreenViewType() : Int
}