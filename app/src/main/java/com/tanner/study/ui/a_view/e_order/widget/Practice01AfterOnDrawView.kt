package com.tanner.study.ui.a_view.e_order.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView


/**
 * Created by Tanner on 2017/9/13.
 */
class Practice01AfterOnDrawView : ImageView {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.color = Color.parseColor("#FFC107")
        paint.textSize = 28f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        val bounds = drawable.bounds
        canvas?.drawText(String.format("尺寸%sX%s",bounds.width(),bounds.height()),20f,40f,paint)
    }

}