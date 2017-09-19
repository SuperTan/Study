package com.tanner.study.ui.a_view.e_order.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet








/**
 * Created by Tanner on 2017/9/13.
 */
class Practice02BeforeOnDrawView : AppCompatTextView {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bounds = RectF()
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.color = Color.parseColor("#FFC107")
    }

    override fun onDraw(canvas: Canvas?) {

        bounds.left = layout.getLineLeft(1)
        bounds.right = layout.getLineRight(1)
        bounds.top = layout.getLineTop(1).toFloat()
        bounds.bottom = layout.getLineBottom(1).toFloat()
        canvas?.drawRect(bounds, paint)
        bounds.left = layout.getLineLeft(layout.lineCount - 3)
        bounds.right = layout.getLineRight(layout.lineCount - 3)
        bounds.top = layout.getLineTop(layout.lineCount - 3).toFloat()
        bounds.bottom = layout.getLineBottom(layout.lineCount - 3).toFloat()
        canvas?.drawRect(bounds, paint)

        super.onDraw(canvas)
    }

}