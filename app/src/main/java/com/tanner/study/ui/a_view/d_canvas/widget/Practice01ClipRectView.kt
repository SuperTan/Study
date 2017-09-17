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
class Practice01ClipRectView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm: Bitmap

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        //原图
        canvas?.drawBitmap(bm, 0f, 0f, paint)
        canvas?.restore()

        val left: Float = (width - bm?.width) / 2f
        val top: Float = (height - bm?.height) / 2f
        //屏幕中间
        var f: Float = 100f
        //裁剪
        canvas?.clipRect(left + f, top + f, left + bm.width - f, top + bm.height - f)

        canvas?.drawBitmap(bm, left, top, paint)

    }

}