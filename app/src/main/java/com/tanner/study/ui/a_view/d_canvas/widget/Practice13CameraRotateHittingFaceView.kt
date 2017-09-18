package com.tanner.study.ui.a_view.d_canvas.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.tanner.study.R


/**
 * Created by Tanner on 2017/9/13.
 */
class Practice13CameraRotateHittingFaceView : View {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm: Bitmap
    var cam: Camera = Camera()
    var mat: Matrix = Matrix()

    internal var degree: Int = 0

    internal var anim: ObjectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 360)


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)
        var scaleBitmap = Bitmap.createScaledBitmap(bm, bm.width * 2, bm.height * 2, true)
        bm.recycle()
        bm = scaleBitmap

        anim.duration = 5000
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = ValueAnimator.INFINITE

        var displayMetrics = resources.displayMetrics
        var newZ = -displayMetrics.density * 6
        cam.setLocation(0f, 0f, newZ)

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        anim.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        anim.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var centerX = 100f + bm.width / 2f
        var centerY = 100f + bm.height / 2f

        cam.save()
        mat.reset()
        cam.rotateX(degree.toFloat())
        cam.getMatrix(mat)
        cam.restore()
        mat.preTranslate(-centerX, -centerY)
        mat.postTranslate(centerX, centerY)
        canvas?.save()
        canvas?.concat(mat)
        canvas?.drawBitmap(bm, 100f, 100f, paint1)
        canvas?.restore()


    }

}