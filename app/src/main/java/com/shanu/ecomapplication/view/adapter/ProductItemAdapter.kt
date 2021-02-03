package com.shanu.ecomapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shanu.ecomapplication.R
import com.shanu.ecomapplication.databinding.ProductItemRowBinding
import com.shanu.ecomapplication.model.ProductListResponse
import com.shanu.ecomapplication.utils.OnItemClickListener
import com.shanu.ecomapplication.viewModel.ProductViewModel
import java.util.*

class ProductItemAdapter() : RecyclerView.Adapter<ProductItemAdapter.DateViewHolder>() {

    private var prodItemList: MutableList<ProductListResponse>? = ArrayList()
    private lateinit var productItemRowBinding: ProductItemRowBinding
    private lateinit var listener: OnItemClickListener

    init {
        this.prodItemList = arrayListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        productItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.product_item_row,
            parent, false
        )
        return DateViewHolder(productItemRowBinding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bindScanItemDetail(prodItemList!![position])
    }

    override fun getItemCount(): Int {
        return prodItemList!!.size
    }

    fun setProductItemList(prodList: MutableList<ProductListResponse>) {
        this.prodItemList = prodList
        notifyDataSetChanged()
    }

    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class DateViewHolder(private var productItemRowBinding: ProductItemRowBinding) :
        RecyclerView.ViewHolder(productItemRowBinding.root) {

        fun bindScanItemDetail(productListResponse: ProductListResponse) {

            if (productItemRowBinding.prodItemViewModel == null) {
                productItemRowBinding.prodItemViewModel = ProductViewModel(productListResponse, itemView.context)
            } else {
                productItemRowBinding.prodItemViewModel!!.setProductDetail(productListResponse)
                productItemRowBinding.executePendingBindings()
            }
        }
    }

}