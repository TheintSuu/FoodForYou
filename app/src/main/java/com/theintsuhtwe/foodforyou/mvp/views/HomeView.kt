package com.theintsuhtwe.foodforyou.mvp.views

import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.shared.mvp.BaseView

interface HomeView : BaseView {

    fun dispalyHomeScreenViewType(viewType: Int)

    fun displayCategory(podCast: List<CategoryVO>)

    fun displayNewRestuarnts(podCastsList: List<ShopVO>)


    fun displayPopularFoodItems(foodItemList: List<FoodItemVO>)

    fun navigateToResturantsDeatail(shopId: String)

}

