package com.example.mvp.presenter

import com.example.mvp.model.IModel
import com.example.mvp.view.IView


open class BasePresenter<M : IModel, V : IView>(protected var mModel: M?, protected var mView: V?) :IPresenter {

    override fun destory() {
        if (mModel != null) {
            mModel!!.destory()
            mModel = null
        } else if (mView != null) {
            mView = null
        }
    }
}