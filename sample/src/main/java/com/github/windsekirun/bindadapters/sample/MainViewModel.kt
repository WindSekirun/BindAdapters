package com.github.windsekirun.bindadapters.sample

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableList
import android.net.Uri
import android.view.View
import com.github.windsekirun.bindadapters.observable.ObservableString
import pyxis.uzuki.live.richutilskt.utils.rangeList

/**
 * BindAdapters
 * Class: MainViewModel
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */

class MainViewModel : LifecycleObserver {
    val value = ObservableString()
    val imageUri = ObservableField(Uri.parse("https://picsum.photos/200"))
    val spinnerEntries: ObservableList<String> = ObservableArrayList()
    val spinnerValue = ObservableString()
    val intValue = ObservableInt(1)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        spinnerEntries.addAll(rangeList(1.0, 5.0, 0.1).map { it.toString() })
    }

    fun onFocusChanged(view: View, hasFocus: Boolean) {

    }

    fun onItemSelected(item: Any?) {

    }
}