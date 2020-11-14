package com.theintsuhtwe.foodforyou.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.delegate.FoodItemDelegate
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_new_shop.view.tvFoodTitle
import kotlinx.android.synthetic.main.item_popular_food_home.view.*


class PopularFoodViewHolder  (itemView : View, delegate : FoodItemDelegate) : BaseViewHolder<FoodItemVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
               // mDelegate.onTapRestaurant(it)
            }
        }

    }



    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tvFoodRating.text = data?.rating.toString()
            itemView.tvFoodTitle.text = data?.name

            data?.imgurl?.let{

                loadImage(
                        itemView.context as Activity,
                        it,
                        itemView.ivFooditem)


            }

        }
    }


}