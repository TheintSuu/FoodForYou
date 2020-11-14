package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.DetailFoodItemDelegate
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.CategoryViewHolder
import com.theintsuhtwe.foodforyou.views.viewholders.DetailFoodViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter
import com.theintsuhtwe.shared.viewholders.BaseViewHolder

class DetailFoodItemAdpater(delegate : DetailFoodItemDelegate) : BaseAdapter<BaseViewHolder<FoodItemVO>, FoodItemVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailFoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return  DetailFoodViewHolder(view, mDelegate)
    }
}