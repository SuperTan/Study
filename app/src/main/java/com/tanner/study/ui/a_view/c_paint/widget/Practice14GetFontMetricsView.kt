package com.tanner.study.ui.a_view.c_paint.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View



/**
 * Created by Tanner on 2017/9/13.
 */
class Practice14GetFontMetricsView: View{
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf("A", "a", "J", "j", "Â", "â")
    var tops:Float=200f
    var bottoms:Float=400f

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        paint1.style=Paint.Style.STROKE
        paint1.textSize=20f
        paint1.color=Color.parseColor("#E91E63")

        paint2.textSize=160f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(50f, tops, width - 50f, bottoms, paint1)

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        val middle = (tops + bottoms) / 2
        val fontMetrics = paint2.fontMetrics
        var y=(fontMetrics.ascent+fontMetrics.descent)/2


        canvas?.drawText(texts[0], 100f, middle-y, paint2)
        canvas?.drawText(texts[1], 200f, middle-y, paint2)
        canvas?.drawText(texts[2], 300f, middle-y, paint2)
        canvas?.drawText(texts[3], 400f, middle-y, paint2)
        canvas?.drawText(texts[4], 500f, middle-y, paint2)
        canvas?.drawText(texts[5], 600f, middle-y, paint2)

    }

}