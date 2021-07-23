package com.example.lianxi7_18.mvp

import android.util.Log
import com.example.lianxi7_18.contract.MyContract
import com.example.lianxi7_18.entity.FoodEntity
import com.example.mvp.presenter.BasePresenter

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MyPresenter(mModel: MyContract.FoodModel?, mView: MyContract.FoodView?) :BasePresenter<MyContract.FoodModel, MyContract.FoodView>(mModel, mView) {

    fun getFood() {
        mModel!!.food(object : Observer<FoodEntity> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(foodEntity: FoodEntity) {
                mView!!.foodadapter(foodEntity)
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {

            }
        })
    }
}
