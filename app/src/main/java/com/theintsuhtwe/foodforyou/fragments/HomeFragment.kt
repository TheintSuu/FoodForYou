package com.theintsuhtwe.foodforyou.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.activities.DetailActivity
import com.theintsuhtwe.foodforyou.adapters.CategoryAdapter
import com.theintsuhtwe.foodforyou.adapters.ShopAdapter
import com.theintsuhtwe.foodforyou.adapters.PopularFoodItemAdapter
import com.theintsuhtwe.foodforyou.data.vos.CategoryVO
import com.theintsuhtwe.foodforyou.data.vos.FoodItemVO
import com.theintsuhtwe.foodforyou.data.vos.ShopVO
import com.theintsuhtwe.foodforyou.mvp.presenters.HomePresenter
import com.theintsuhtwe.foodforyou.mvp.presenters.HomePresenterImpl
import com.theintsuhtwe.foodforyou.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), HomeView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mCategoryAdapter: CategoryAdapter
    lateinit var mPopularFoodAdapter: PopularFoodItemAdapter
    lateinit var mPopularRestaurantAdapter: PopularFoodItemAdapter
    lateinit var mNewShopAdapter: ShopAdapter

    lateinit var mPresenter :  HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val v = inflater.inflate(R.layout.fragment_home, container, false)

        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpRecyclerView()

        mPresenter.onUiReady(this)
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        rvCategory.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvPopularCategory.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvShop.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


        mCategoryAdapter = CategoryAdapter (mPresenter)
        rvCategory.adapter = mCategoryAdapter

        mPopularFoodAdapter = PopularFoodItemAdapter (mPresenter)
        rvPopularCategory.adapter = mPopularFoodAdapter
    }

    override fun dispalyHomeScreenViewType(viewType: Int) {
        if(viewType == 0)
        {
            location_layout.visibility =View.VISIBLE
           rvCategory.visibility = View.VISIBLE
            layoutHomeTitlte.visibility= View.GONE
            rvPopularCategory.visibility =View.GONE
            mNewShopAdapter = ShopAdapter(mPresenter, 0)
            rvShop.adapter = mNewShopAdapter
        }else
        {
            location_layout.visibility =View.GONE
            rvCategory.visibility = View.GONE
            layoutHomeTitlte.visibility= View.VISIBLE
            rvPopularCategory.visibility =View.VISIBLE
            mNewShopAdapter = ShopAdapter(mPresenter, 1)
            rvShop.adapter = mPopularRestaurantAdapter
        }
    }

    override fun displayCategory(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setData(categoryList as MutableList<CategoryVO>)
    }

    override fun displayNewRestuarnts(podCastsList: List<ShopVO>) {
        mNewShopAdapter.setData(podCastsList as MutableList<ShopVO>)
    }

    override fun displayPopularFoodItems(foodItemList: List<FoodItemVO>) {
        mPopularFoodAdapter.setData(foodItemList as MutableList<FoodItemVO>)
    }

    override fun navigateToResturantsDeatail(shopId: String) {
        startActivity(  activity?.applicationContext?.let{ DetailActivity.newIntent(it, shopId)})
    }
}