package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice09MatrixRotateView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text: String? = "Hello Tanner"

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.textSize = 60f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 50f, 100f, paint)
        // 使用 Paint.setTextScaleX() 来改变文字宽度
        paint.textScaleX = 1f
        canvas?.drawText(text, 50f, 100f + paint.fontSpacing, paint)
        paint . textScaleX =1.2f
        canvas?.drawText(text, 50f, 100f + paint.fontSpacing*2, paint)
        paint . textScaleX =1.5f
        canvas?.drawText(text, 50f, 100f + paint.fontSpacing*3, paint)
        paint . textScaleX =0.8f
        canvas?.drawText(text, 50f, 100f + paint.fontSpacing*4, paint)

    }

}