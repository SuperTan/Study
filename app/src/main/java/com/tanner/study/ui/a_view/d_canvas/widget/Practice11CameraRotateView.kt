package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/9/13.
 */
class Practice11CameraRotateView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm: Bitmap
    var cam: Camera = Camera()

    var centerX1 = 50f
    var centerY1 = 10f
    var centerX2 = 50f
    var centerY2 = 1000f
    var centerX3 = 100f
    var centerY3 = 1500f

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        cam.save()
        cam.rotateX(30f)
        cam.applyToCanvas(canvas)
        cam.restore()
        canvas?.drawBitmap(bm, centerX1, centerY1, paint)
        canvas?.restore()


        canvas?.save()
        cam.save()// 保存 Camera 的状态
        cam.rotateX(30f)// 旋转 Camera 的三维空间
        canvas?.translate(bm.width / 2f + centerX2, bm.height / 2f + centerY2)// 旋转之后把投影移动回来
        cam.applyToCanvas(canvas)// 把旋转投影到 Canvas
        canvas?.translate(-(centerX2 + bm.width / 2f), -(centerY2+bm.height / 2f))// 旋转之前把绘制内容移动到轴心（原点）
        cam.restore()// 恢复 Camera 的状态
        canvas?.drawBitmap(bm, centerX2, centerX2, paint)
        canvas?.restore()

        canvas?.save()
        cam.save()// 保存 Camera 的状态
        cam.rotateX(30f)// 旋转 Camera 的三维空间
        cam.translate(100f,0f,0f)
        canvas?.translate(bm.width / 2f + centerX3, bm.height / 2f + centerY3)// 旋转之后把投影移动回来
        cam.applyToCanvas(canvas)// 把旋转投影到 Canvas
        canvas?.translate(-(centerX3 + bm.width / 2f), -(centerY3+bm.height / 2f))// 旋转之前把绘制内容移动到轴心（原点）
        cam.restore()// 恢复 Camera 的状态
        canvas?.drawBitmap(bm, centerX3, centerX3, paint)
        canvas?.restore()

    }

}