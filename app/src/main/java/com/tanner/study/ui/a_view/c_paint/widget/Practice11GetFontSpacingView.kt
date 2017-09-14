package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice11GetFontSpacingView: View{
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
        // 使用 Paint.getFontSpacing() 来获取推荐的行距
        canvas?.drawText(text, 50f, 100f, paint)
        var spacing:Float = paint.fontSpacing
        canvas?.drawText(text, 50f, 100f+spacing*1, paint)
        canvas?.drawText(text, 50f, 100f+spacing*2, paint)
        canvas?.drawText(text, 50f, 100f+spacing*3, paint)
        canvas?.drawText(text, 50f, 100f+spacing*4, paint)

    }

}