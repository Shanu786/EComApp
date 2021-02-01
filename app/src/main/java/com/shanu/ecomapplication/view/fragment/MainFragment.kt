package com.shanu.ecomapplication.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.make.dots.dotsindicator.DotsIndicator
import com.shanu.ecomapplication.R
import com.shanu.ecomapplication.databinding.FragmentMainBinding
import com.shanu.ecomapplication.model.ProductListResponse
import com.shanu.ecomapplication.utils.OnItemClickListener
import com.shanu.ecomapplication.view.adapter.ProductItemAdapter
import com.shanu.ecomapplication.view.adapter.ViewPagerAdapter
import com.shanu.ecomapplication.viewModel.MainFragViewModel
import com.shanu.ecomapplication.viewModel.common.kodeinViewModel
import kotlinx.android.synthetic.main.view_product.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class MainFragment() : Fragment(), KodeinAware, OnItemClickListener {

    override val kodein by kodein()
    private val mainFragViewModel: MainFragViewModel by kodeinViewModel()
    private lateinit var fragMainBinding: FragmentMainBinding

    private lateinit var itemViewPager: ViewPager
    private lateinit var dotsIndicator: DotsIndicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        itemViewPager = fragMainBinding.root.findViewById(R.id.imageViewPager)
        dotsIndicator = fragMainBinding.root.findViewById(R.id.dotsIndicator)

        setupProductListRowItemView(fragMainBinding.viewProdLayout.list_product)

        val imagesList: ArrayList<Int> = ArrayList()
        imagesList.add(R.drawable.carousel1)
        imagesList.add(R.drawable.carousel2)
        imagesList.add(R.drawable.carousel3)
        imagesList.add(R.drawable.carousel4)
        imagesList.add(R.drawable.carousel5)
        imagesList.add(R.drawable.carousel6)

        itemViewPager.adapter = ViewPagerAdapter(imagesList)
        dotsIndicator.setViewPager(itemViewPager)
        itemViewPager.adapter?.registerDataSetObserver(dotsIndicator.dataSetObserver)

        activity?.let {
            mainFragViewModel?.getProductsList().observe(viewLifecycleOwner, Observer {
                it.let {
                    val productItemAdapter = fragMainBinding.viewProdLayout.list_product.adapter as ProductItemAdapter
                    productItemAdapter.setProductItemList(it as MutableList<ProductListResponse>)
                    productItemAdapter.setListener(this)
                }
            })
        }

        fragMainBinding.lifecycleOwner = viewLifecycleOwner
        return fragMainBinding.root
    }

    private fun setupProductListRowItemView(listProductRecyclerView: RecyclerView?) {
        val productAdapter = ProductItemAdapter()
        listProductRecyclerView?.adapter = productAdapter
        val gridLayoutManager = GridLayoutManager(activity, 2, LinearLayoutManager.HORIZONTAL, false)
        listProductRecyclerView?.layoutManager = gridLayoutManager // set LayoutManager to RecyclerView
        productAdapter.setListener(this)
    }

}