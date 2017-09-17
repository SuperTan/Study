package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice08MatrixScaleView : View{
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
        canvas?.drawText(text, 50f, 100f, paint)
        // 使用 Paint.setTextSkewX() 来让文字倾斜
        paint.textSkewX=1f
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing, paint)
        paint.textSkewX=2f
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing*2, paint)
        paint.textSkewX=3f
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing*3, paint)
        paint.textSkewX=-0.5f
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing*4, paint)
        paint.textSkewX=-1f
        canvas?.drawText(text, 50f, 100f+paint.fontSpacing*5, paint)

    }

}