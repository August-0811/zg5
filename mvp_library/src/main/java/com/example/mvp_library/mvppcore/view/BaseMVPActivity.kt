package com.example.mvp_library.mvppcore.view

import com.example.mvp_library.mvppcore.BasePresenter
import com.example.mvp_library.mvppcore.BaseRepository
import com.example.mvp_library.mvppcore.IModel
import com.example.mvp_library.mvppcore.IView

/**
 * @Author : August
 * @Time : On 2021/7/22 19:28
 */
abstract class BaseMVPActivity<P:BasePresenter<BaseRepository<IModel>,IView>>: BaseActivity() {
    protected lateinit var mPresenter:BasePresenter<BaseRepository<IModel>,IView>

    /**
     * 初始化
     */

    init {
        mPresenter = createPresenter()
    }

    abstract fun createPresenter(): P


}