package com.example.mvptext.model

import android.os.SystemClock
import com.example.mvptext.callback.RegisterCallBack
import com.example.mvptext.contract.UserCenterContract

/**
 * @Author : August
 * @Time : On 2021/7/22 21:03
 */
class UserCenterModelmpl : UserCenterContract.UsernameCenterModel{
    override fun register(phoneNumber: String, pwd: String, callback: RegisterCallBack) {
        //耗时操作
        SystemClock.sleep(1000)
        callback.success("success")
    }
}