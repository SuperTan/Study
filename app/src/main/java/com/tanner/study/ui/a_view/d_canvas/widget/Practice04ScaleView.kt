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
class Practice04ScaleView : View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
var bm :Bitmap

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
//        paint.textSize=60f
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心
//        canvas?.save()
//        canvas?.drawBitmap(bm, 10f, 10f, paint)
//        canvas?.restore()

        canvas?.save()
        canvas?.scale(1f,1f,bm.width/2f,bm.height/2f)
        canvas?.drawBitmap(bm, 10f, 10f, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.scale(0.5f,0.5f,100f,100f)
        canvas?.drawBitmap(bm, 10f, 10f+bm.height*2, paint)
        canvas?.restore()

    }

}