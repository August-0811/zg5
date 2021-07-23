package com.example.hanshu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fourBigVararg = getFourBigVararg("可修改参数","参数1","参数2","参数3","参数4","参数5","参数6","参数7")
        Log.i("zxw",fourBigVararg)

        //默认函数 参数
        val default = default(default1 = "修改参数1")
        Log.i("zxw",default)

        //数组类型参数
        val array = array(
            "String参数",
            arrayOf("数组一（1）", "数组一（2）", "数组一（3）"),
            arrayOf("数组二（1）", "数组二（2）", "数组二（3）")
        )
        Log.i("zxw",array)


        //泛型函数  函数名称后添加<变量类型>
        val appendString = appendString(2,3,4, 6,7,65)
        Log.i("zxw",appendString)


    }



    //默认参数
    fun default(default1:String = "默参数1",default2:String = "默参数2"):String{
        var str:String = "$default1,$default2"
        return str
    }


    //vararg 可变参数
    //general:String, first:String=" 潇洒潇洒 ", second:String=" 撒啊阿萨 ", third:String=" 法律常识", fourth:String=" 生产订单"
    fun getFourBigVararg(vararg otherArray: String?):String {
    var answer:String = ""
    //$general：$first,$second,$third,$fourth
    for (item in otherArray) {
        answer = "$answer҅$item"
    }
    return answer
}


    //数组类型函数
    fun array(parameter:String = "parametet",vararg other:Array<String>):String{
        var answer:String = parameter

        //遍历每个数组
        for (strings in other) {
            //遍历每个数组中的值
            for (item in strings) {
                answer = "$answer,$item"
            }
        }

        return answer
    }


    //泛型函数
    fun <T> appendString(vararg otherInfo:T?):String{

        var str:String = ""

        //遍历泛型类型
        for (item in otherInfo) {
            str = "$str,${item.toString()}"
        }
        return str
    }

    //内连函数 在fun前面添加 inline
//    inline fun <>

}
