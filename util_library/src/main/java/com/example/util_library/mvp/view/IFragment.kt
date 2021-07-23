package com.example.mvp.view

import android.view.View
import androidx.annotation.IdRes

interface IFragment : IActivity{
    abstract fun <T : View> findViewById(@IdRes id: Int): T
}