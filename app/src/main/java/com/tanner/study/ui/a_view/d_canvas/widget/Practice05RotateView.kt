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
class Practice05RotateView : View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        paint.textSize=60f
        bm=BitmapFactory.decodeResource(resources, R.drawable.maps)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //degrees 是旋转角度，单位是度（也就是一周有 360° 的那个单位），方向是顺时针为正向； px 和 py 是轴心的位置。
        canvas?.save()
        canvas?.drawBitmap(bm,10f,10f,paint)
        canvas?.restore()

        canvas?.save()
        canvas?.rotate(45f,bm.width/2f+10f,bm.height/2f+10f+bm.height)
        canvas?.drawBitmap(bm,10f,10f+bm.height,paint)
        canvas?.restore()

        canvas?.save()
        canvas?.rotate(90f,bm.width/2f+10f,bm.height/2f+10f+bm.height*2)
        canvas?.drawBitmap(bm,10f,10f+bm.height*2,paint)
        canvas?.restore()

        canvas?.save()
        canvas?.rotate(135f,bm.width/2f+10f,bm.height/2f+10f+bm.height*3)
        canvas?.drawBitmap(bm,10f,10f+bm.height*3,paint)
        canvas?.restore()


    }

}