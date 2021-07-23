package com.example.day006_work

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator

class CustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    var paint: Paint? = null

    init {
        paint = Paint().also {
            it.color = Color.WHITE
            it.style = Paint.Style.FILL
            it.strokeWidth = 10f
            it.textSize = 50f
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("",200f,150f,paint!!)
    }

    fun am(){
        X_Animator()
        Y_Animator()
    }


    private fun X_Animator() {
        var X:ObjectAnimator = ObjectAnimator.ofFloat(this,"scaleX",2f)
        X.duration = 2000
        X.interpolator = LinearInterpolator()
        X.repeatMode = REVERSE
        X.repeatCount = 1
        X.start()
    }

    private fun Y_Animator() {
        var Y :ObjectAnimator = ObjectAnimator.ofFloat(this,"scaleY",2f)
        Y.duration = 2000
        Y.interpolator = LinearInterpolator()
        Y.repeatMode = REVERSE
        Y.start()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            am()
        }
        return true
    }






}