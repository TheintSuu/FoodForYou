package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.FoodItemDelegate
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.CategoryViewHolder
import com.theintsuhtwe.foodforyou.views.viewholders.PopularFoodViewHolder
import com.theintsuhtwe.foodforyou.views.viewholders.RestaurantViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter
import com.theintsuhtwe.shared.viewholders.BaseViewHolder

class PopularFoodItemAdapter (delegate : FoodItemDelegate) : BaseAdapter<BaseViewHolder<FoodItemVO>, FoodItemVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PopularFoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_food_home, parent, false)
        return PopularFoodViewHolder(view, mDelegate)
    }

}