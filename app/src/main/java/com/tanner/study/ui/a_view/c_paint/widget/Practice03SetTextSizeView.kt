package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice03SetTextSizeView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text: String? = "Hello Tanner"

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var y: Float = 100f
        var x: Float = 50f
        // 使用 paint.setTextSize() 来设置不同大小的文字

        // 第一处：文字大小 16
        paint.textSize = 16f
        canvas?.drawText(text, x, y, paint)

        y += 30f
        // 第一处：文字大小 24
        paint.textSize = 24f
        canvas?.drawText(text, x, y, paint)

        y += 55f
        // 第一处：文字大小 48
        paint.textSize = 48f
        canvas?.drawText(text, x, y, paint)

        y += 80f
        // 第一处：文字大小 72
        paint.textSize = 72f
        canvas?.drawText(text, x, y, paint)

    }

}