@file:JvmName("InternalEx")

package com.github.windsekirun.bindadapters.utils

import android.databinding.adapters.ListenerUtil
import android.view.View

/**
 * BindAdapters
 * Class: InternalEx
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */

/**
 * remove implicit type such as ListenerUtil.trackListener<ViewPager.OnPageChangeListener>
 */
internal fun <T> trackListener(view: View, listener: T?, listenerResourceId: Int): T? =
        ListenerUtil.trackListener(view, listener!!, listenerResourceId)