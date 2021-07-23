package com.example.day005_zhuoye

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        getData()

        var array:Array<String> = arrayOf(Manifest.permission.READ_CONTACTS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(array,100)
        }
    }



    private fun initView() {

        val layoutManaget = LinearLayoutManager(applicationContext)
        layoutManaget.orientation = LinearLayoutManager.VERTICAL
        rec.setHasFixedSize(true)
        //设置布局管理器
        rec.layoutManager = layoutManaget

    }


    private fun getData() {
        val list = ArrayList<TextBean>()
        Log.i("zxw",list.toString())
        val myAdapter = MyAdapter(applicationContext,list)
        rec.adapter = myAdapter

    }

}
