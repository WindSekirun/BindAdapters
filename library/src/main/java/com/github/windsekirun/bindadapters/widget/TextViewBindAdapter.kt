package com.github.windsekirun.bindadapters.widget

import android.databinding.BindingAdapter
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.graphics.Typeface
import android.widget.TextView

/**
 * BindAdapters
 * Class: TextViewBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */
@BindingMethods(
        BindingMethod(type = TextView::class, attribute = "android:onEditorAction", method = "setOnEditorActionListener")
)
object TextViewBindAdapter {

    @JvmStatic
    @BindingAdapter("android:textStyle")
    fun TextView.setTypeface(style: String) {
        when (style) {
            "bold" -> setTypeface(null, Typeface.BOLD)
            "italic" -> setTypeface(null, Typeface.ITALIC)
            "bold|italic" -> setTypeface(null, Typeface.BOLD_ITALIC)
            else -> setTypeface(null, Typeface.NORMAL)
        }
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun TextView.bindFloat(value: Float) {
        text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun TextView.bindDouble(value: Double) {
        text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun TextView.bindInt(value: Int) {
        text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun TextView.bindLong(value: Long) {
        text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun TextView.bindBoolean(value: Boolean) {
        text = value.toString()
    }
}