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
        //θζΆζδ½
        SystemClock.sleep(1000)
        callback.success("success")
    }
}