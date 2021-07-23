package com.example.lianxi7_18.common

import com.example.lianxi7_18.entity.FoodEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    fun getFood(): Observable<FoodEntity> //@Query("page") int

}