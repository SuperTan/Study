package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice08MatrixScaleView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mat: Matrix = Matrix()
    var bm: Bitmap

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
        mat.postScale(0.5f, 0.5f,100f+bm.width/2f,100f+bm.height/2f)//sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f, paint)
        canvas?.restore()

        canvas?.save()
        mat.reset()
        mat.postScale(1.2f, 1.2f,100f+bm.width/2f,100f+bm.height/2f+bm.height)
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f+bm.height, paint)
        canvas?.restore()


    }

}