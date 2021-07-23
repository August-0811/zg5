package com.example.mvp_library.mvppcore.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_library.mvppcore.common.ConstValue

/**
 * @Author : August
 * @Time : On 2021/7/22 9:19
 * @Description : BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
        initData()
        initEvent()

        if (isClearStarBar()){
            ClearStatBar()
        }

        //跳转
        fun jumpActivity(otherActivity:Class<*>){
            startActivity(Intent(this@BaseActivity,otherActivity))
        }

        /**
         * 带参跳转
         */
        fun jumpActivity(otherActivity:Class<*>,parems:Bundle?){
            val intent:Intent = Intent(this@BaseActivity,otherActivity)
            intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,parems)
            startActivity(intent)
        }

        /**
         * 显示消息
         */
        fun showMsg(msg:String){
            Toast.makeText(this@BaseActivity,msg,Toast.LENGTH_SHORT).show()
        }

        /**
         *
         */

    }

    //去掉状态栏实现沉浸式
    fun ClearStatBar(){

    }

    abstract fun isClearStarBar(): Boolean
    //初始化
    abstract fun initEvent()

    abstract fun initData()

    abstract fun initView()

    abstract fun getLayout(): Int

    override fun onStop() {
        super.onStop()
        releasResource()
    }

    //释放资源
    abstract fun releasResource()


}