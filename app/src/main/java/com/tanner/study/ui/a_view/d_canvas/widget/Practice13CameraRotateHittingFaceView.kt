package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View


/**
 * Created by Tanner on 2017/9/13.
 */
class Practice13CameraRotateHittingFaceView : View {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var text1: String? = "A"
    var text2: String? = "a"
    var text3: String? = "J"
    var text4: String? = "j"
    var text5: String? = "Â"
    var text6: String? = "â"
    var tops: Float = 200f
    var bottoms: Float = 400f


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(50f, tops, width - 50f, bottoms, paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差


        val middle = (tops + bottoms) / 2f
        var rect=Rect()
        paint2.getTextBounds(text1,0,text1?.length as Int,rect)
        var y1:Float=(rect.top+rect.bottom)/2f
        paint2.getTextBounds(text2,0,text2?.length as Int,rect)
        var y2:Float=(rect.top+rect.bottom)/2f
        paint2.getTextBounds(text3,0,text3?.length as Int,rect)
        var y3:Float=(rect.top+rect.bottom)/2f
        paint2.getTextBounds(text4,0,text4?.length as Int,rect)
        var y4:Float=(rect.top+rect.bottom)/2f
        paint2.getTextBounds(text5,0,text5?.length as Int,rect)
        var y5:Float=(rect.top+rect.bottom)/2f
        paint2.getTextBounds(text6,0,text6?.length as Int,rect)
        var y6:Float=(rect.top+rect.bottom)/2f

        canvas?.drawText(text1, 100f, middle-y1, paint2)
        canvas?.drawText(text2, 200f, middle-y2, paint2)
        canvas?.drawText(text3, 300f, middle-y3, paint2)
        canvas?.drawText(text4, 400f, middle-y4, paint2)
        canvas?.drawText(text5, 500f, middle-y5, paint2)
        canvas?.drawText(text6, 600f, middle-y6, paint2)
    }

}