package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.RestaurantViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter
import com.theintsuhtwe.shared.viewholders.BaseViewHolder

class ShopAdapter  (delegate : RestaurantItemDelegate, private val mviewType: Int) : BaseAdapter<BaseViewHolder<ShopVO>, ShopVO>() {
    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_shop, parent, false)
//        return NewRestaurantViewHolder(view, mDelegate)


        return when (mviewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_shop_by_category, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_new_shop, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }
        }


    }

}