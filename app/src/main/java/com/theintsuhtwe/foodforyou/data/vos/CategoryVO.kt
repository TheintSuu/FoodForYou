package com.theintsuhtwe.foodforyou.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class CategoryVO(
        var id: String?= "",
        var name: String? = "",
        var image: String? = ""
)