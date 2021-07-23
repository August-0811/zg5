package com.example.lianxi7_18.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.week001_work.R

object  GlideUtils {
    private var glideUtils: GlideUtils
        get() {
            TODO()
        }
        set(value) {}


    fun getInstance(): GlideUtils {
        if (glideUtils == null)
            synchronized(GlideUtils::class.java) {
            if (glideUtils == null)
                glideUtils
        }
        return glideUtils
    }

    //方形图片
    fun GetGlide(context: Context, path: String, imageView: ImageView) {
        Glide.with(context)
            .load(path)
            .into(imageView)
    }

    //圆形图片
    fun GetCircleGlide(context: Context, path: String, imageView: ImageView) {
        Glide.with(context)
            .load(path)
            .transform(CircleCrop())
            .into(imageView)
    }
}