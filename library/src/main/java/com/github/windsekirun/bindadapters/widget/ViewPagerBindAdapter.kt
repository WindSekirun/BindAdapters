package com.github.windsekirun.bindadapters.widget

import android.databinding.*
import android.support.v4.view.ViewPager
import com.github.windsekirun.bindadapters.R
import com.github.windsekirun.bindadapters.utils.trackListener

/**
 * BindAdapters
 * Class: ViewPagerBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */

@BindingMethods(
        BindingMethod(type = ViewPager::class, attribute = "android:offscreenPageLimit", method = "setOffscreenPageLimit"),
        BindingMethod(type = ViewPager::class, attribute = "android:adapter", method = "setAdapter"),
        BindingMethod(type = ViewPager::class, attribute = "android:currentPage", method = "setCurrentItem"))
object ViewPagerBindAdapter {

    interface OnPageScrolled {
        fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
    }

    interface OnPageSelected {
        fun onPageSelected(position: Int)
    }

    interface OnPageScrollStateChanged {
        fun onPageScrollStateChanged(state: Int)
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:currentPage", event = "android:currentPageAttrChanged")
    fun ViewPager.getCurrentPage(): Int {
        return this.currentItem
    }

    @JvmStatic
    @BindingAdapter(value = ["android:onPageScrolled", "android:onPageSelected", "android:onPageScrollStateChanged", "android:currentPageAttrChanged"], requireAll = false)
    fun ViewPager.onSetAdapter(scrolled: OnPageScrolled?,
                               selected: OnPageSelected?,
                               scrollStateChanged: OnPageScrollStateChanged?,
                               currentPageAttrChanged: InverseBindingListener?) {

        val newValue: ViewPager.OnPageChangeListener?
        if (scrolled == null && selected == null && scrollStateChanged == null && currentPageAttrChanged == null) {
            newValue = null
        } else {
            newValue = object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    scrolled?.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    selected?.onPageSelected(position)
                    currentPageAttrChanged?.onChange()
                }

                override fun onPageScrollStateChanged(state: Int) {
                    scrollStateChanged?.onPageScrollStateChanged(state)
                }
            }
        }
        val oldValue = trackListener(this, newValue, R.id.page_change_listener)
        if (oldValue != null) {
            this.removeOnPageChangeListener(oldValue)
        }
        if (newValue != null) {
            this.addOnPageChangeListener(newValue)
        }
    }
}