package com.theintsuhtwe.foodforyou.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.DetailFoodItemDelegate
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_food.view.*

class DetailFoodViewHolder (itemView: View, private val mDelegate:DetailFoodItemDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tvFoodName.text =data?.name
            itemView.tvFoodDetail.text = data?.description
            itemView.tvRating.text =data?.rating
            itemView.tvPrice.text =data?.price.toString()
            data?.imgurl?.let{

                        loadImage(
                                itemView.context as Activity,
                                it,
                                itemView.ivFoodItem)


            }
            itemView.btnAdd.setOnClickListener{
                mDelegate.onTapFoodItemToCart(data)
            }
        }
    }
}