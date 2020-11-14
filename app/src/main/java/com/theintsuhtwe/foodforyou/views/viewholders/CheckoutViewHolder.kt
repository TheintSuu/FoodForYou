package com.theintsuhtwe.foodforyou.views.viewholders

import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.CheckoutItemDelegate
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.layout_food_item_checkout.view.*

class CheckoutViewHolder(itemView: View, private val mDelegate: CheckoutItemDelegate) :
BaseViewHolder<FoodItemVO>(itemView) {

    init{
        itemView.setOnClickListener {
            mData?.let {

            }
        }

    }
    override fun bindData(data: FoodItemVO) {
       itemView.tvCheckoutFoodItemCount.text = data.count.toString()
        itemView.tvCheckoutFoodPrice.text = data.price.toString()
        itemView.tvCheckoutFoodItem.text = data.name
    }

}