package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice06SkewView : View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        bm=BitmapFactory.decodeResource(resources, R.drawable.maps)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //sx 和 sy 是 x 方向和 y 方向的错切系数。
        canvas?.save()
        canvas?.skew(0f, 0.5f)
        canvas?.drawBitmap(bm,10f,10f,paint)
        canvas?.restore()

        canvas?.save()
        canvas?.skew(0.5f, 0.5f)
        canvas?.drawBitmap(bm,10f,10f+bm.height,paint)
        canvas?.restore()

        canvas?.save()
        canvas?.drawBitmap(bm,10f,10f+bm.height*2,paint)
        canvas?.restore()

    }

}