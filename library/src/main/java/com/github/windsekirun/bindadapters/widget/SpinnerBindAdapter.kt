package com.github.windsekirun.bindadapters.widget

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

/**
 * BindAdapters
 * Class: SpinnerBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */

object SpinnerBindAdapter {

    interface ItemSelectedListener {
        fun onItemSelected(item: Any?)
    }

    @JvmStatic
    @BindingAdapter("entries")
    fun Spinner.setEntries(entries: List<String>?) {
        if (entries != null) {
            val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, entries)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            adapter = arrayAdapter
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["onItemSelected", "selectedValueAttrChanged"], requireAll = false)
    fun Spinner.setListener(itemSelectedListener: ItemSelectedListener?,
                            inverseBindingListener: InverseBindingListener?) {
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (tag != position) {
                    itemSelectedListener?.onItemSelected(parent.getItemAtPosition(position))
                    inverseBindingListener?.onChange()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    @JvmStatic
    @BindingAdapter("selectedValue")
    fun Spinner.setSelectedValue(selectedValue: String?) {
        if (adapter != null) {
            val position = (adapter as ArrayAdapter<String>).getPosition(selectedValue)
            setSelection(position, false)
            tag = position
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    fun Spinner.getSelectedValue(): String? {
        return selectedItem as String
    }
}