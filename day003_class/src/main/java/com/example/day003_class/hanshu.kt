package com.example.day003_class

import android.content.Context
import android.widget.Toast

class hanshu constructor(context:Context,nam:String){
    init {
        Toast.makeText(context,nam,Toast.LENGTH_SHORT).show()
    }
}

/**
 * @JvmOverloads java代码也可以识别默认参数
 * constructor 因为添加了注解标记 所以要 写
 */
class AnimalDefault @JvmOverloads constructor  (context:Context,name:String = "母鸡",sex:Int = 0){
    init {
        var sexName:String = if (sex == 0) "公" else "母"
        Toast.makeText(context,"这只${name}是${sexName}的",Toast.LENGTH_SHORT).show()
    }
}

class WildAnimalCompanion(var name:String,val sex:Int = 0){

    companion object wil{
        fun judgeSex(sexName:String):Int{
            var sex:Int = when(sexName){
                "公","雄" -> 0
                "母","雌" -> 1

                else -> -1
            }
            return sex
        }
    }

}

    class JingTai(){
        companion object st{
            val MALE = 0
        }
    }

    abstract class chouxiang(){

    }

    interface Behavior{
       fun fly():String

        fun swim():String

        fun run():String{
            return "run"
        }

        var skill:String
    }

    class Be:Behavior{
        override fun fly(): String {
            return "fly_be"
        }

        override fun swim():String{
            return "swim_be"
        }

        override fun run(): String {
            return "run_be"
        }

        override var skill:String = "skill_be"
    }

    class Tree(var treeName:String){
        class Flower (var flowerName:String){
            fun getName():String{
                return "这是一朵$flowerName"
            }
        }


        //加inner边内部类
        inner class Fruit(var furitName:String){
           fun getName():String{
               return "这是${treeName}长出来的$furitName"
           }
        }


    }

enum class SeasonName(var seasonName:String){
    SRRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")
}






