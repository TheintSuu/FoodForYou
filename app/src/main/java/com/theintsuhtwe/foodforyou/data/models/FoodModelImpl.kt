package com.theintsuhtwe.foodforyou.data.models

import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.network.CloudFirestoreFirebaseApiImpl
import com.theintsuhtwe.foodforyou.network.FirebaseApi
import com.theintsuhtwe.foodforyou.network.remoteconfig.FirebaseRemoteConfigManager

object FoodModelImpl : FoodModel {
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager


    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit) {
       mFirebaseApi.getCategory(onSuccess, onFaiure)
    }

    override fun getRestaurants(onSuccess: (List<ShopVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getRestaurants(onSuccess, onFaiure)
    }

    override fun getAllFoodItemsByShop(
        shopId: String,
        onSuccess: (List<FoodItemVO>, ShopVO) -> Unit,
        onFaiure: (String) -> Unit
    ) {
        mFirebaseApi.getDetailFoodList(shopId, onSuccess, onFaiure)
    }

    override fun getPopularFoodItems(onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit) {
       mFirebaseApi.getPopularFoodItemList(onSuccess, onFaiure)
    }

    override fun getTotalFoodItemCount(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit) {
        mFirebaseApi.getCartFoodItemCount(onSuccess,onFialure)
    }

    override fun getTotalPrice(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit) {
        mFirebaseApi.getTotalPrice(onSuccess,onFialure)
    }

    override fun addFoodItem(item: FoodItemVO) {
     mFirebaseApi.addFoodItem(item)
    }

    override fun setUpRemoteConfig() {
       mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
     mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getHomeScreenViewType(): Int {
      val v =  mFirebaseRemoteConfigManager.getMainScreenViewType().toInt()
        return v
    }
}