package com.shanu.ecomapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shanu.ecomapplication.R
import com.shanu.ecomapplication.model.ProductListResponse
import com.shanu.ecomapplication.retrofit.api.ApiInterface
import com.shanu.ecomapplication.retrofit.base.BaseRepository

class MainFragRepository(var apiInterface: ApiInterface) : BaseRepository() {

    private var productListResponse: MutableLiveData<List<ProductListResponse>> = MutableLiveData()

    fun getProductsListResponse(): MutableList<ProductListResponse> {
        var productListData: MutableList<ProductListResponse> = ArrayList()

        var productItem1 = ProductListResponse()
        productItem1.prodName = "Black T-shirt"
        productItem1.offerMsg = "Flat 10% Off"
        productItem1.prodImage = R.drawable.prod1 //"https://tinyurl.com/y4f5e96j"

        var productItem2 = ProductListResponse()
        productItem2.prodName = "Red Check Shirt"
        productItem2.offerMsg = "Flat 20% Off"
        productItem2.prodImage = R.drawable.prod2 //"https://tinyurl.com/y2szwrys"

        var productItem3 = ProductListResponse()
        productItem3.prodName = "Navy Blue T-shirt"
        productItem3.offerMsg = "Flat 15% Off"
        productItem3.prodImage = R.drawable.prod3 //"https://tinyurl.com/y4bfj5b7"

        var productItem4 = ProductListResponse()
        productItem4.prodName = "Blue Check Shirt"
        productItem4.offerMsg = "Flat 25% Off"
        productItem4.prodImage = R.drawable.prod4 //"https://tinyurl.com/y44marw5"

        var productItem5 = ProductListResponse()
        productItem5.prodName = "HRX Yellow Shirt"
        productItem5.offerMsg = "Flat 15% Off"
        productItem5.prodImage = R.drawable.prod5 //"https://tinyurl.com/y4urobx8"

        var productItem6 = ProductListResponse()
        productItem6.prodName = "Light Green Kurti"
        productItem6.offerMsg = "Flat 10% Off"
        productItem6.prodImage = R.drawable.prod6 //"https://tinyurl.com/y2yhf95n"

        var productItem7 = ProductListResponse()
        productItem7.prodName = "Ladies Western Dress"
        productItem7.offerMsg = "Flat 30% Off"
        productItem7.prodImage = R.drawable.prod7 //"https://tinyurl.com/y5n467o3"

        var productItem8 = ProductListResponse()
        productItem8.prodName = "Traditional Saree"
        productItem8.offerMsg = "Flat 40% Off"
        productItem8.prodImage = R.drawable.prod8 //"https://tinyurl.com/yxupqdll"

        productListData.addAll(listOf(productItem1, productItem2, productItem3, productItem4, productItem5,
            productItem6, productItem7, productItem8))
        Log.e("scanItemVal", "scanItemVal :: $productListData")
        productListResponse.postValue(productListData)

        return productListData
    }

}