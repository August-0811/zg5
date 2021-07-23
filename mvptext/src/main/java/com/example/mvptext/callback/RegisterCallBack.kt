package com.example.mvptext.callback

/**
 * @Author : August
 * @Time : On 2021/7/22 20:05
 */
interface RegisterCallBack {
        fun <T> success(data:T)
        fun failed(throwable:Throwable)

}