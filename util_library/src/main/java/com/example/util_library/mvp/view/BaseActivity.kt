package com.example.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp.presenter.IPresenter

abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), IActivity, IView {
    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLyout())
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter!!.destory()
            presenter = null
        }
    }
}