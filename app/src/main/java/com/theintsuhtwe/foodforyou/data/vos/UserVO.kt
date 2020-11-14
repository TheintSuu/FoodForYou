package com.theintsuhtwe.foodforyou.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class UserVO(
    var name: String? = "",
    var email: String? = "",
    var image : String?= ""
)