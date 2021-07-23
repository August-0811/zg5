package com.example.lianxi7_18.mvp

import com.example.lianxi7_18.common.Api
import com.example.lianxi7_18.contract.MyContract
import com.example.lianxi7_18.entity.FoodEntity
import com.example.lianxi7_18.utils.RetrofitUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyModel : MyContract.FoodModel {
    override fun food(observer: Observer<FoodEntity>) {
        val retrofit = RetrofitUtils.retrofitUtils.retrofit
        val api = retrofit.create(Api::class.java)
        api.getFood()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    override fun destory() {

    }
}
