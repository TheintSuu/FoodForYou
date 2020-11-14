package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.CategoryViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter
import com.theintsuhtwe.shared.viewholders.BaseViewHolder

class CategoryAdapter (delegate : RestaurantItemDelegate) : BaseAdapter<BaseViewHolder<CategoryVO>, CategoryVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return  CategoryViewHolder(view, mDelegate)



    }
}