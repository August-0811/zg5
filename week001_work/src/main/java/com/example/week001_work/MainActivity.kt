package com.example.lianxi7_18

import androidx.recyclerview.widget.GridLayoutManager
import com.example.lianxi7_18.adapter.FoodAdapter
import com.example.lianxi7_18.contract.MyContract
import com.example.lianxi7_18.entity.FoodEntity
import com.example.lianxi7_18.mvp.MyModel
import com.example.lianxi7_18.mvp.MyPresenter
import com.example.mvp.view.BaseActivity
import com.example.week001_work.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MyPresenter>(),MyContract.FoodView {
    var food:FoodAdapter?=null


    override fun foodadapter(foodEntity: FoodEntity) {
        var data = foodEntity.data
        food = FoodAdapter(R.layout.food_item,data)
        rec.layoutManager= GridLayoutManager(this,2)
        rec.adapter=food
    }

    override fun bindLyout(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        presenter= MyPresenter(MyModel(),this)
        presenter!!.getFood()
    }

    override fun initView() {
    }


}
