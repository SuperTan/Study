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
class Practice03TranslateView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm: Bitmap
//    var point1: Point = Point(200, 200)
//    var point2: Point = Point(200, 600)


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        canvas?.drawBitmap(bm, 10f, 10f, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(bm.width/1f,0f)
        canvas?.drawBitmap(bm, 200f, 200f, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.drawBitmap(bm, 10f, 700f, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(bm.width/1f,bm.height/2f)
        canvas?.drawBitmap(bm, 200f, 700f, paint)
        canvas?.restore()



    }

}