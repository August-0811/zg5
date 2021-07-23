package com.example.mvp_library.mvppcore

abstract class BaseRepository<M:IModel>{

    /**
     * 数据仓库层
     */

    protected lateinit var mModel:M


    init {
        mModel = createModel()
    }

    abstract fun createModel(): M

}