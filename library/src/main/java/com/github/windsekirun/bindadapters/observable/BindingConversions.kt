package com.github.windsekirun.bindadapters.observable

import androidx.databinding.BindingConversion

/**
 * BindAdapters
 * Class: BindingConversions
 * Created by pyxis on 18. 7. 9.
 *
 * Description: Internal usages for ObservableString.kt
 */

@BindingConversion
fun convertToString(s: ObservableString): String? {
    return s.get()
}