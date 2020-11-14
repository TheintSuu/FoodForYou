package com.theintsuhtwe.foodforyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.CheckoutItemDelegate
import com.theintsuhtwe.foodforyou.views.viewholders.CheckoutViewHolder
import com.theintsuhtwe.shared.adapters.BaseAdapter

class CheckoutItemAdapter(private val mDelegate: CheckoutItemDelegate) :
        BaseAdapter<CheckoutViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_food_item_checkout, parent, false)
        return CheckoutViewHolder(view, mDelegate)

    }
}
