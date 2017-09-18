package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice12CameraRotateFixedView : View {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap
    var mat: Matrix = Matrix()
    var cam: Camera = Camera()


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var centerX1:Float=bm.width/2+100f
        var centerY1:Float=bm.height/2+100f
        var centerX2:Float=bm.width/2+100f
        var centerY2:Float=bm.height/2+100f+bm.height

        cam.save()
        mat.reset()
        cam.rotateX(30f)
        cam.getMatrix(mat)
        cam.restore()
        mat.preTranslate(-centerX1, -centerY1)
        mat.postTranslate(centerX1, centerY1)
        canvas?.save()
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f, paint1)
        canvas?.restore()

        cam.save()
        mat.reset()
        cam.rotateX(30f)
        cam.getMatrix(mat)
        cam.restore()
        mat.preTranslate(-centerX2, -centerY2)
        mat.postTranslate(centerX2, centerY2)
        canvas?.save()
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f+bm.height, paint1)
        canvas?.restore()


    }

}