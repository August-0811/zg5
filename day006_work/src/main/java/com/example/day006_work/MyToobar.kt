package com.example.test7_21

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.day006_work.R

class MyToobar : RelativeLayout {

    //标题栏所包含的三个控件
    var leftbutton: Button?=null
    var title: TextView?=null
    var righttext: TextView?=null

    //标题中心文字的属性
    var titlename: String?=null
    var titlesize: Float?=0f
    var titlecolor: Int?=0

    //左边按钮的属性
    var leftbg: Drawable?=null

    //右边文字的属性
    var rightname: String?=null
    var rightsize: Float?=0f
    var rightcolor: Int?=0

    var leftParams: RelativeLayout.LayoutParams?=null
    var titleParams: RelativeLayout.LayoutParams?=null
    var rightParams: RelativeLayout.LayoutParams?=null


    private var leftButtonListener: LeftButtonListener? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyToolBar)
        //获取xml文件中的属性值
        titlename = typedArray?.getString(R.styleable.MyToolBar_titlename)
        titlesize = typedArray.getDimension(R.styleable.MyToolBar_titlesize, 0f)
        titlecolor = typedArray.getColor(R.styleable.MyToolBar_titlecolor, 0)

        leftbg = typedArray.getDrawable(R.styleable.MyToolBar_leftbg)

        rightname = typedArray.getString(R.styleable.MyToolBar_righttext)
        rightsize = typedArray.getDimension(R.styleable.MyToolBar_rightsize, 0f)
        rightcolor = typedArray.getInt(R.styleable.MyToolBar_rightcolor, 0)
        //回收，避免浪费资源以及未知的缓存错误
        typedArray.recycle()

        //实例化控件
        leftbutton = Button(context)
        title = TextView(context)
        righttext = TextView(context)

        //属性赋给定义的控件
        title?.text = titlename
        title?.textSize = titlesize as Float
        title?.setTextColor(titlecolor!!)
        title?.gravity = Gravity.CENTER

        leftbutton?.background = leftbg

        righttext?.text = rightname
        righttext?.textSize = rightsize as Float
        righttext?.setTextColor(rightcolor!!)

        setBackgroundColor(Color.parseColor("#63B8FF"))

        //定义子控件在父容器中的位置
        leftParams = RelativeLayout.LayoutParams(100, 100)
        leftParams?.marginStart = 20
        leftParams?.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
        leftParams?.addRule(RelativeLayout.CENTER_VERTICAL)

        addView(leftbutton, leftParams)


        titleParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        titleParams?.addRule(RelativeLayout.CENTER_IN_PARENT)
        addView(title, titleParams)

        rightParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        rightParams?.marginEnd = 20
        rightParams?.addRule(RelativeLayout.CENTER_VERTICAL)
        rightParams?.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
        addView(righttext, rightParams)

        //给左边的按钮设置点击事件
        leftbutton?.setOnClickListener {
            //执行回调方法
            leftButtonListener!!.LeftBtnOnclick()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    fun setOnToolbarclickListener(listener: LeftButtonListener) {
        leftButtonListener = listener
    }

    interface LeftButtonListener {
        fun LeftBtnOnclick()
    }

}
