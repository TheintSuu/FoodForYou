package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.adapters.ImageSliderAdapter
import com.theintsuhtwe.foodforyou.mvp.presenters.HomePresenterImpl
import com.theintsuhtwe.foodforyou.mvp.presenters.SliderPreseneterImpl
import com.theintsuhtwe.foodforyou.mvp.presenters.SliderPresenter
import com.theintsuhtwe.foodforyou.mvp.views.SliderView
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_slider.*

class SliderActivity : BaseActivity(), SliderView {

    companion object{
        fun newIntent(context: Context): Intent = Intent(context,SliderActivity::class.java)
    }


  lateinit var mAdapter : ImageSliderAdapter

    lateinit var  mPresenter : SliderPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        setUpPresenter()
        setUpViewPager()
        setUpListener()
        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SliderPreseneterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }



    private fun setUpListener() {
        btnCreateAccount.setOnClickListener {
            mPresenter.onTapCreateAccount()
        }

        tvLogin.setOnClickListener {
            mPresenter.onTapLoginButton()
        }

    }

    private fun setUpViewPager() {
        mAdapter = ImageSliderAdapter(this)
        vpImageSlider.adapter = mAdapter
        TabLayoutMediator(tabLayout,vpImageSlider){tab,position->{

        }}.attach()

    }

}