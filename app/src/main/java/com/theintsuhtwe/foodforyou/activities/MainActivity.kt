package com.theintsuhtwe.foodforyou.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.theintsuhtwe.foodforyou.R
import com.theintsuhtwe.foodforyou.fragments.HomeFragment
import com.theintsuhtwe.foodforyou.fragments.OtherFragment
import com.theintsuhtwe.foodforyou.fragments.ProfileFragment
import com.theintsuhtwe.foodforyou.utils.FRAGMENT_Home
import com.theintsuhtwe.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callFragment(HomeFragment.newInstance("a", "b"))
        setUpBottomNavigation()
    }


    fun setUpBottomNavigation(){
        BottomNav.setOnNavigationItemSelectedListener (object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_home -> {
                        callFragment(HomeFragment.newInstance("a", "b"))
                        return true
                    }
                    R.id.nav_other -> {
                        callFragment(OtherFragment.newInstance("a", "b"))
                        return true
                    }
                    R.id.nav_profile -> {
                        callFragment(ProfileFragment.newInstance("a", "b"))
                        return true
                    }

                }
                return false

            }
        })
    }

    fun callFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction().
            replace(R.id.container, fragment)
            .addToBackStack(FRAGMENT_Home).commit()
    }

}