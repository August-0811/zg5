package com.example.day006_work

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class CustomFlowView: ViewGroup{

    //左部距离
    internal var left:Int = 0
    //顶部距离
    internal var top:Int = 0
    //说有子布局总长度
    internal var curLen:Int = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    //控件大小
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //子控件个数
        var childCount = childCount

        for (i in 0 until  childCount){
            var chilAt = getChildAt(i)
            //获取每一个子控件
            measureChild(chilAt,widthMeasureSpec,heightMeasureSpec)
        }
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var childCount = childCount

        /**
         * 整体思路是:
         * 第一个view正常布局.不管如何都是定边放置
         * 从第二个view开始. 要判断总长度.能放下 ,就放到一行.
         * 放不下的情况,要从头开始放置.
         * 不同的放置,就是调整left.和 top的位置.  让宽+left 和 高加top 即可.
         *
         */

        for (j in 0 until childCount){
            val childAt = getChildAt(j)
            //first
            if (j == 0){
                childAt.layout(left,top,childAt.measuredWidth,childAt.measuredHeight)
                left += childAt.measuredWidth
                curLen = childAt.measuredWidth
                //继续
                continue
            }

                //当前位置
                curLen += childAt.measuredWidth
                if (curLen<measuredWidth){
                    childAt.layout(left,top,childAt.measuredWidth+left,childAt.measuredHeight+top)
                    left += childAt.measuredWidth
                }else{
                    //大于控件长度换行  长度归零
                    left = 0
                    curLen = childAt.measuredWidth
                    top += childAt.measuredHeight

                    childAt.layout(left,top,childAt.measuredWidth+left,childAt.measuredHeight+top)
                    left += childAt.measuredWidth
                }




        }

    }


}