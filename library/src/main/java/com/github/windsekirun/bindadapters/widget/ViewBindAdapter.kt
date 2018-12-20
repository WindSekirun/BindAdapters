package com.github.windsekirun.bindadapters.widget

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.InverseBindingAdapter
import android.view.View
import android.widget.EditText

/**
 * BindAdapters
 * Class: ViewBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */

@BindingMethods(
        BindingMethod(type = View::class, attribute = "android:onFocusChanged", method = "setOnFocusChangeListener"),
        BindingMethod(type = View::class, attribute = "android:selected", method = "setSelected")
)
object ViewBindAdapter {

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:selected", event = "android:selectedAttrChanged")
    fun View.getSelected(): Boolean {
        return isSelected
    }
}