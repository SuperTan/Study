package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice10MatrixSkewView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm: Bitmap
    var mat: Matrix = Matrix()


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        mat.reset()
        mat.postSkew(0.5f, 0f)
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f, paint)
        canvas?.restore()

        canvas?.save()
        mat.reset()
        mat.postSkew(0f, 0.5f)
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f+bm.height, paint)
        canvas?.restore()

        canvas?.save()
        mat.reset()
        mat.postSkew(0.5f, 0.5f)
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 0f, 100f+bm.height*2, paint)
        canvas?.restore()


    }

}