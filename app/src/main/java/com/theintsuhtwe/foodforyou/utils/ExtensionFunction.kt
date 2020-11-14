package com.theintsuhtwe.foodforyou.utils

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(itemView: Activity, url: String, toImageView: ImageView) {
    Glide.with(itemView)
            .load(url)
            .centerCrop()
            .into(toImageView)
}