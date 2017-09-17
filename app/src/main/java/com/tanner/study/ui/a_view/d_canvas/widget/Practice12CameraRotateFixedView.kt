package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice12CameraRotateFixedView : View {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var text1: String? = "Hello Tanner"
    var text2: String? = "你多少岁了"
    var text3: String? = "18"

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制

        canvas?.drawText(text1, 50f, 200f, paint1);
        canvas?.drawText(text2, 50f + paint1.measureText(text1), 200f, paint2);
        canvas?.drawText(text3, 50f + paint1.measureText(text1) + paint2.measureText(text2), 200f, paint1)

    }

}