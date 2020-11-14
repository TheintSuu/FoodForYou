package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.data.models.FoodModelImpl
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.mvp.views.DetailView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private val mDetailModel = FoodModelImpl
    override fun onUiReady(shopId: String, lifecycleOwner: LifecycleOwner) {
        getAllDetailData(shopId, lifecycleOwner)
    }

    override fun onTapFoodIteToCart() {
        
    }

    override fun onTapFoodItemToCart(data: FoodItemVO) {
        var totalAmount= data.count * data.price
        data.totalAmount= totalAmount
        mDetailModel.addFoodItem(data)

        mDetailModel.getTotalFoodItemCount(
                onSuccess = {
                    mView?.displayCartCount(it)
                },
                onFialure = {

                })
    }

    private fun getAllDetailData(shopId : String,lifecycleOwner :LifecycleOwner){

        mDetailModel.getTotalFoodItemCount(
                onSuccess = {
                    mView?.displayCartCount(it)
                },
                onFialure = {

                })

        mDetailModel.getAllFoodItemsByShop(
        shopId,
        onSuccess = {
            dataList, restaurant ->
            mView?.displayPopularFood(
                    dataList.filter{ data -> data.popular
                    }
            )
            mView?.displayRestaurant(restaurant)
            mView?.displayFoodItemList(dataList)
        },
        onFaiure = {

        })
    }
}