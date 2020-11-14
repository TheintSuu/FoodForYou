package com.theintsuhtwe.foodforyou.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_shop_by_category.view.*


class RestaurantViewHolder  (itemView : View, delegate : RestaurantItemDelegate) : BaseViewHolder<ShopVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
                 mDelegate.onTapRestaurant(it)
            }
        }

    }

    override fun bindData(data: ShopVO) {
        mData = data

        data.imgUrl.let {
            it?.let { it1 ->
                loadImage(
                        itemView.context as Activity,
                        it1,
                        itemView.ivPopularShop)
            }
        }

        //itemView.tvPodCastTimeLeft.text = data.audio_length_sec.toString()
        itemView.tvFoodTitle.text = data.name
        itemView.tvShopDetail.text = data.description
        itemView.tvShopRating.text = data.rating

    }


}