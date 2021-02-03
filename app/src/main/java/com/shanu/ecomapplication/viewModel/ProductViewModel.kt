package com.shanu.ecomapplication.viewModel

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.shanu.ecomapplication.model.ProductListResponse
import java.util.*

class ProductViewModel(private var prodItemModel: ProductListResponse?, private val context: Context) : Observable() {

    val productName: String?
        get() = prodItemModel!!.prodName

    val productOffer: String?
        get() = prodItemModel!!.offerMsg

    val productImage: Int?
        get() = prodItemModel!!.prodImage

    fun setProductDetail(prodItemModel: ProductListResponse) {
        this.prodItemModel = prodItemModel
    }

}