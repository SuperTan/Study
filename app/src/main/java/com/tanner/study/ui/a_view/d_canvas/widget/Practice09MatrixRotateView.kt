package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice09MatrixRotateView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap
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
        mat.postRotate(45f,bm.width/2f+100f,bm.height/2f+100f)//旋转
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f, paint)
        canvas?.restore()

        canvas?.save()
        mat.reset()
        mat.postRotate(90f,bm.width/2f+100f,bm.height/2f+bm.height+100f)//旋转
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f+bm.height, paint)
        canvas?.restore()

        canvas?.save()
        canvas?.drawBitmap(bm, 100f, 100f+bm.height*2, paint)
        canvas?.restore()

    }

}