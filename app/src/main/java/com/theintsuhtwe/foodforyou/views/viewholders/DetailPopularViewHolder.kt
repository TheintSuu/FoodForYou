package com.theintsuhtwe.foodforyou.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.DetailFoodItemDelegate
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.item_popular_food.view.*

class DetailPopularViewHolder (itemView: View, private val mDelegate:DetailFoodItemDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tvPopularFoodPrice.text = data?.price.toString()
            itemView.tvPopularFoodname.text = data?.name

            data?.imgurl?.let{

                loadImage(
                        itemView.context as Activity,
                        it,
                        itemView.ivPopularFood)


            }
            itemView.btnAdd.setOnClickListener{
                mDelegate.onTapFoodItemToCart(data)
            }
        }
    }
}