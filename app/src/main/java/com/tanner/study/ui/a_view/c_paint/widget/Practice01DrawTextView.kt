package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice01DrawTextView: View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text: String? = "Hello Tanner"

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        paint.textSize=60f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 使用 drawText() 来绘制文字
        // 文字坐标： (50, 100)
//        paint.textSize=60f
        canvas?.drawText(text, 50f, 100f, paint)

    }

}