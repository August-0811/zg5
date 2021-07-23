package com.example.mvp_library.mvppcore

import java.lang.ref.SoftReference

abstract class BasePresenter <Repo:BaseRepository<*>,V:IView>(_view:V){
    protected lateinit var mRepository:BaseRepository<*>
    //软引用防止内存泄漏
    protected lateinit var mView:SoftReference<V>

    init {
        mRepository = createRepoitory()
        mView = SoftReference<V>(_view)
    }

    abstract fun createRepoitory(): Repo
}