package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.adapters.CheckoutItemAdapter
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.mvp.presenters.CheckoutPresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.CheckoutPresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.CheckoutView
import com.theintsuhtwe.foodforyou.utils.loadImage
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.item_checkout_restaturant.*
import kotlinx.android.synthetic.main.layout_checkout_success.view.*

class CheckoutActivity : BaseActivity(), CheckoutView {

    private lateinit var mPresenter: CheckoutPresenter
    private lateinit var mCheckoutAdapter: CheckoutItemAdapter
    private lateinit var mOrderList: List<FoodItemVO>

    companion object {
        var shopdata : ShopVO ?= null
        const val CHECKOUT_ID = "CHECKOUT_ID"


        fun newIntent(context: Context,
                      data : ShopVO
        ): Intent {
            val intent = Intent(context, CheckoutActivity::class.java)
            shopdata = data
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        setUpPresenter()

        setUpRecyclerView()

        setUpActionListener()

        shopdata?.let { bindData(it) }



    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CheckoutPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){

        rvOrderItemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

           mCheckoutAdapter = CheckoutItemAdapter(mPresenter)
    }

    private fun setUpActionListener(){
        btnCheckout.setOnClickListener {
            if(mOrderList.isNotEmpty()) {
              dispalyBottomSheet()
            }else
            {
                Toast.makeText(this,"Empty Cart Item",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun bindData(shop : ShopVO){
        tvRating.text = shop.rating

        shop.imgUrl?.let {
            loadImage(
                    this,
                    it,
                    ivCheckoutShop)
        }

        tvRestartantName.text = shop.name
        tvRestaurtantDetail.text = shop.description
    }

    override fun displayOrderList(orderList: List<FoodItemVO>) {
        mOrderList = orderList
        mCheckoutAdapter.setData(orderList as MutableList<FoodItemVO>)
    }

    override fun displayTotalAmount(totalAmount: Long) {
        tvTotalAmount.text = "{totalAmount} $"
    }


    private fun dispalyBottomSheet(){
        val view = layoutInflater.inflate(R.layout.layout_checkout_success, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        view.btnOrderTrack.setOnClickListener {

            Toast.makeText(this, "Order Track Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
            mPresenter.onTapCheckout(this,orderList = mOrderList)
            finish()

        }
        view.btnElse.setOnClickListener {
            Toast.makeText(this, "Order Cancel Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
        dialog.show()
    }


}