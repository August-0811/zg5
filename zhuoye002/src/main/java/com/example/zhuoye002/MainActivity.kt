package com.example.zhuoye002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    companion object {
        var index: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        index

        //调用函数
        val default = default()
        Log.i("zxw","调用函数:${default}")


        //调用高阶泛型函数


        var string_array:Array<String> = arrayOf("How", "do", "you", "do", "I'm", "Fine")
        string_array.max()
        //按长度比较
        Log.i("zxw", "高阶泛型函数:字符串按长度比较最大值为${Horder(string_array,{a,b -> a.length > b.length})}")

        //调用高阶函数
        val max = max(1, 3, { a, b -> a + b })
        Log.i("zxw","调用高阶函数:${max}")

        //调用内敛函数
        var int_array:Array<Int> = arrayOf(1,2,3)
        val arrayStr = setArrayStr<Int>(int_array)
        Log.i("zxw","调内敛函数:${arrayStr}")

        var array:Array<String> = arrayOf("1","2","3","4","5","6","7","8")
        array.stringExtend(0,7)
        array.forEach {

        }
    }


    fun function(){

    }

    //创建默认参数值的函数
    fun default(a:Int = 10,b:Int = 20):Int{
        return a+b
    }

    //创建高阶泛型函数
    //允许将函数表达式作为输入参数传进来
    //如果第一个参数大大于第二个参数就会返回true 反则否之

    fun<T> Horder(array:Array<T>,greater:(T,T)->Boolean):T? {
        var max: T? = null
        for (item in array) {
            if (max == null || greater(item, max)) {
                max = item
            }
        }
        return max
    }

    //创建高阶函数
    fun max(a:Int,b:Int,ass:(Int,Int)->Int):Int{
        return ass(a,b)
    }

    //创建内联函数
    inline fun <reified T:Number> setArrayStr(array: Array<T>):String{
        var str:String = "数组函数依次排列:"

        for (item in array) {
            str = str + item.toString() + ","
        }
        return str
    }



    //创建String扩展高阶函数
    //stringExtend 后的参数表示 下标  并不是元素
    fun Array<String>.stringExtend(string1:Int,string2:Int){
        val tmp = this[string1] //this 数组
        this[string1] = this[string2]
        this[string2] = tmp

    }

}


