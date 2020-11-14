package com.theintsuhtwe.foodforyou.views.viewholders

import android.app.Activity
import android.view.View
import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.delegate.RestaurantItemDelegate
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder (itemView : View, delegate : RestaurantItemDelegate) : BaseViewHolder<CategoryVO>(itemView){
    val mDelegate = delegate
    init{
        itemView.setOnClickListener {
            mData?.let {
              // mDelegate.onTapRestaurant(it.categoryId)
            }
        }

    }

    override fun bindData(data: CategoryVO) {
        mData = data

        data.image?.let {
            loadImage(
                    itemView.context as Activity,
                    it,
                    itemView.ivCategory)
        }

        //itemView.tvPodCastTimeLeft.text = data.audio_length_sec.toString()
        itemView.tvCategory.text = data.name

    }


}