package com.tanner.study.ui.a_view.e_order.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet


/**
 * Created by Tanner on 2017/9/13.
 */
class Practice08BeforeDrawView : AppCompatEditText {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun draw(canvas: Canvas?) {

        // 在 super.draw() 的上方插入绘制代码，让绘制内容被其他所有内容盖住
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        canvas?.drawColor(Color.parseColor("#66BB6A")) // 涂上绿色

        super.draw(canvas)

    }


}