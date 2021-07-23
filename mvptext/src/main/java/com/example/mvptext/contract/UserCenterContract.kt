package com.example.mvptext.contract

import com.example.mvp_library.mvppcore.BasePresenter
import com.example.mvp_library.mvppcore.BaseRepository
import com.example.mvp_library.mvppcore.IModel
import com.example.mvp_library.mvppcore.IView
import com.example.mvptext.callback.RegisterCallBack

/**
 * @Author : August
 * @Time : On 2021/7/22 19:40
 */
interface UserCenterContract {
    interface UsernameCenterModel:IModel{

        fun register(phoneNumber:String,pwd:String,callback:RegisterCallBack)

        }

        abstract class UserCenterRepository:BaseRepository<UsernameCenterModel>(){
            abstract fun register(phoneNumber:String,pwd:String,callback:RegisterCallBack)
        }

        interface UserCenterView:IView{
            fun <T>RegisterSuccess(data:T)
            fun RegisterFailed(throwable: Throwable)
        }

        abstract class UserCenterPresenter(view:UserCenterView):BasePresenter<UserCenterRepository,UserCenterView>(view){
            abstract fun register(phoneNumber:String,pwd:String)
        }

}