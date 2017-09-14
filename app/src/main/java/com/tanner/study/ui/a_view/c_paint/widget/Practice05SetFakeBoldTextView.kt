package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice05SetFakeBoldTextView: View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text: String? = "Hello Tanner"

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        paint.textSize=60f
        // 使用 Paint.setFakeBoldText() 来加粗文字


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 50f, 100f, paint)
        paint.isFakeBoldText=true
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing, paint)

    }

}