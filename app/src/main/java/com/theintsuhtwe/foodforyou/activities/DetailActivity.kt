package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.adapters.DetailFoodItemAdpater
import com.theintsuhtwe.foodforyou.adapters.DetailPopularFoodAdapter
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.mvp.presenters.DetailPresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.DetailPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.DetailView
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_detail.*

class DetailActivity : BaseActivity(), DetailView {

    private lateinit var mPresenter: DetailPresenter
    private lateinit var mDetailAdapter: DetailPopularFoodAdapter
    private lateinit var mDetailFoodItemAdapter:  DetailFoodItemAdpater
    private lateinit var mRestaurantVO: ShopVO


    companion object {
        const val SHOP_ID = "Shop ID"
        fun newIntent(context: Context,
                      documentId: String
        ) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(SHOP_ID, documentId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()

        val podCastId = intent.getStringExtra(SHOP_ID)

        podCastId?.let { mPresenter.onUiReady(it, this) }

    }


    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        rvDetailPopularList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFoodItemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mDetailAdapter = DetailPopularFoodAdapter(mPresenter)
       rvDetailPopularList.adapter = mDetailAdapter

       mDetailFoodItemAdapter = DetailFoodItemAdpater (mPresenter)
       rvFoodItemList.adapter =mDetailFoodItemAdapter
    }

    private fun setUpActionListener(){
        btnCart.setOnClickListener{

            startActivity(CheckoutActivity.newIntent(this,   mRestaurantVO))
        }
    }
    override fun displayRestaurant(shopVO: ShopVO) {
        mRestaurantVO = shopVO

        mRestaurantVO.imgUrl?.let {
            loadImage(
                this,
                it,
                ivDetailImage
            )
        }
        tvDetailDescription.text = mRestaurantVO.description
        tvDetailRating.text = mRestaurantVO.rating
        tvDetailTitle.text = mRestaurantVO.name




    }

    override fun displayPopularFood(popularFoodList: List<FoodItemVO>) {
        mDetailFoodItemAdapter.setData(popularFoodList as MutableList<FoodItemVO>)
    }

    override fun displayFoodItemList(foodList: List<FoodItemVO>) {
        mDetailAdapter.setData(foodList as MutableList<FoodItemVO>)
    }

    override fun displayCartCount(cartCount: Long) {
        if(cartCount>0){
            btnCart.visibility = View.VISIBLE
            btnCart.text = "VIEW CART " +cartCount  + "ITEMS"
        }else{
            btnCart.visibility = View.GONE

        }

    }
}