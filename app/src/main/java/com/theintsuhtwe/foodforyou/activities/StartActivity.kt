package com.theintsuhtwe.foodforyou.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.theintsuhtwe.foodforyou.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setUpListener()
    }

    private fun setUpListener(){
        btnGetStart.setOnClickListener {
            startActivity(SliderActivity.newIntent(this))
        }
    }
}