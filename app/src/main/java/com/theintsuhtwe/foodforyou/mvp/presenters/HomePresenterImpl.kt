package com.theintsuhtwe.foodforyou.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.foodforyou.data.models.FoodModel
import com.theintsuhtwe.foodforyou.data.models.FoodModelImpl
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.mvp.views.HomeView
import com.theintsuhtwe.shared.mvp.presenter.AbstractBasePresenter

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    private val mFoodModel  : FoodModel = FoodModelImpl
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        getAllData(lifeCycleOwner)
    }

    override fun onTapRestaurant(rest: ShopVO) {
      mView?.navigateToResturantsDeatail(rest.id.toString())
    }

    override fun onTapFoodItem(item: FoodItemVO) {

    }

    private fun getAllData(lifeCycleOwner: LifecycleOwner){
        mFoodModel.getCategories(onSuccess = {
            mView?.displayCategory(it)
        },onFaiure = {

        })

        mFoodModel.getRestaurants(onSuccess = {
            mView?.displayNewRestuarnts(it)
        },onFaiure = {

        })

        mFoodModel.getPopularFoodItems(onSuccess = {
            mView?.displayPopularFoodItems(it)
        },onFaiure = {

        })

        mView?.dispalyHomeScreenViewType(mFoodModel.getHomeScreenViewType())


    }
}