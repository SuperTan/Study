package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice07MatrixTranslateView : View{
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap
    var mat:Matrix= Matrix()

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        mat.reset()
        mat.postTranslate(100f, 100f)
        canvas?.concat(mat)//Canvas.setMatrix() 改为 Canvas.concat()，避免有些机型中出现的显示问题。
        canvas?.drawBitmap(bm, 100f, 100f, paint)
        canvas?.restore()

        canvas?.save()
        mat.reset()
        mat.postTranslate(-100f, 200f)
        canvas?.concat(mat)//Canvas.setMatrix() 改为 Canvas.concat()，避免有些机型中出现的显示问题。
        canvas?.drawBitmap(bm, 100f, 100f+bm.height, paint)
        canvas?.restore()


    }

}