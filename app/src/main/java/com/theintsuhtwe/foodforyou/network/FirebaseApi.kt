package com.theintsuhtwe.foodforyou.network

import android.graphics.Bitmap
import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO


interface FirebaseApi {
    fun getCategory(onSuccess: (groceries: List<CategoryVO>) -> Unit, onFialure: (String) -> Unit)
    fun  getRestaurants(onSuccess: (groceries: List<ShopVO>) -> Unit, onFialure: (String) -> Unit)
    fun  getPopularFoodItemList(onSuccess: (groceries: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun getDetailFoodList(shopId : String, onSuccess: (groceries: List<FoodItemVO>, ShopVO) -> Unit, onFialure: (String) -> Unit)
    fun addCheckoutItem(onSuccess: (groceries: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun UpadateCheckoutItem(onSuccess: (groceries: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun addFoodItem(oodItemVO: FoodItemVO)
    fun uploadProfileImage(image : Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)
    fun getCartFoodItemCount(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit)
    fun getTotalPrice(onSuccess: (count: Long) -> Unit, onFialure: (String) -> Unit)
}