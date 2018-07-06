package com.github.windsekirun.bindadapters.widget

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


/**
 * BindAdapters
 * Class: ImageViewBindAdapter
 * Created by Pyxis on 7/7/18.
 *
 * Description:
 */
object ImageViewBindAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.bindImage(url: Uri) {
        Glide.with(this.context).load(url).into(this)
    }

    @JvmStatic
    @BindingAdapter("circleImageUrl")
    fun ImageView.bindCircleImage(url: Uri) {
        Glide.with(this.context).load(url).apply(RequestOptions.circleCropTransform()).into(this)
    }
}