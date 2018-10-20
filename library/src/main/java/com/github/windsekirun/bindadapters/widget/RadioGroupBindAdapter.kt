package com.github.windsekirun.bindadapters.widget

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import android.widget.RadioGroup

/**
 * BindAdapters
 * Class: RadioGroupBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */
@BindingMethods(
        BindingMethod(type = RadioGroup::class, attribute = "android:onRadioChanged", method = "setOnCheckedChangeListener")
)
object RadioGroupBindAdapter