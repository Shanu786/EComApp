package com.shanu.ecomapplication.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.shanu.ecomapplication.R
import com.shanu.ecomapplication.view.activity.MainActivity
import kotlinx.android.synthetic.main.image_item.view.*

class ViewPagerAdapter(val carouselImages: ArrayList<Int>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as View

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val ctx = container.context
        val view = (ctx as MainActivity).layoutInflater.inflate(R.layout.image_item, container, false)
        view.carouselImgView.setImageResource(carouselImages[position])
        container.addView(view)
        return view
    }

    override fun getCount(): Int = carouselImages.size

    override fun getItemPosition(`object`: Any): Int = super.getItemPosition(`object`)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}