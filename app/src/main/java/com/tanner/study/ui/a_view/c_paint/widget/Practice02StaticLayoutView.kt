package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/8/19.
 */

class Practice02StaticLayoutView : View {
    var paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    val text: String = "Hello\nTanner"

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.textSize = 60f
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.drawText(text, 50f, 100f, paint)
        canvas.translate(0f, 200f)
        var staticLayout: StaticLayout? = StaticLayout(text, paint, 600, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
        staticLayout?.draw(canvas)

    }
}
