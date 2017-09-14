package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice10SetTextAlignView: View{
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
        canvas?.drawText(text, width / 2f, 100f, paint)

        // 使用 Paint.setTextAlign() 来调整文字对齐方式

        // 第一处：使用 Paint.Align.LEFT
        paint.textAlign=Paint.Align.LEFT
        canvas?.drawText(text, width / 2f, 100f+paint.fontSpacing, paint)

        // 第二处：使用 Paint.Align.CENTER
        paint.textAlign=Paint.Align.CENTER
        canvas?.drawText(text, width/ 2f, 100f+paint.fontSpacing*2, paint)

        // 第三处：使用 Paint.Align.RIGHT
        paint.textAlign=Paint.Align.RIGHT
        canvas?.drawText(text, width/ 2f, 100f+paint.fontSpacing*3, paint)

    }

}