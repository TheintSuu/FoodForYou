package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.DetailFoodItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.DetailFoodViewHolder
import com.theintsuhtwe.foodforyou.views.viewholders.DetailPopularViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter
import com.theintsuhtwe.shared.viewholders.BaseViewHolder

class DetailPopularFoodAdapter(delegate : DetailFoodItemDelegate) : BaseAdapter<BaseViewHolder<FoodItemVO>, FoodItemVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DetailPopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_food, parent, false)
        return DetailPopularViewHolder(view, mDelegate)
    }
}