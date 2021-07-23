package com.example.day003_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override var skill: String) : AppCompatActivity(),View.OnClickListener,Behavior{
    override fun swim(): String {
        return "swim"
    }

    override fun fly(): String {
        return "接口"
    }

    override fun onClick(v: View?) {
        when(v){
            gz -> hanshu(this,"构造函数")
            mr -> AnimalDefault(this)
            bs -> WildAnimalCompanion.judgeSex("公")
            jt -> JingTai.MALE
            qt -> Tree.Flower("棉花")
            jz -> SeasonName.AUTUMN
        }
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



}
