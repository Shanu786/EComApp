package com.shanu.ecomapplication.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shanu.ecomapplication.model.ProductListResponse
import com.shanu.ecomapplication.retrofit.MainFragRepository

class MainFragViewModel (application: Application, var mainFragRepository: MainFragRepository) : ViewModel() {

//    private lateinit var productListResponse: LiveData<List<ProductListResponse>>

    fun getProductsList(): LiveData<List<ProductListResponse>> {
//        productListResponse = mainFragRepository.getProductsListResponse()
//        return productListResponse
        return liveData {
            var productListResponse = mainFragRepository.getProductsListResponse()
            try {
                emit(productListResponse)
            } catch (e: Exception) {
            }
        }
    }

}