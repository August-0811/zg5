package com.example.lianxi7_18.contract

import com.example.lianxi7_18.entity.FoodEntity
import com.example.mvp.model.IModel
import com.example.mvp.view.IView

import io.reactivex.Observer

interface MyContract {
    interface FoodModel : IModel {
        fun food(observer: Observer<FoodEntity>)
    }

    interface FoodView : IView {
        fun foodadapter(foodEntity: FoodEntity)
    }
}
