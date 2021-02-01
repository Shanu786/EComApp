package com.shanu.ecomapplication.model

import android.media.Image
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductListResponse {
    @SerializedName("prodName")
    @Expose
    var prodName: String? = null

    @SerializedName("offerMsg")
    @Expose
    var offerMsg: String? = null

    @SerializedName("prodImage")
    @Expose
    var prodImage: Int? = null
}