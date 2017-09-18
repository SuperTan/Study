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
class Practice14FlipboardView : View{
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var bm:Bitmap
    var cam=Camera()
    internal var d=1f
    var anim=ObjectAnimator.ofFloat(this,"d",0f,180f)

    constructor(context: Context?) : super(context)

    constructor(context: Context?,attrs: AttributeSet):super(context,attrs)

    constructor(context: Context?,attrs: AttributeSet?, defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init{
        bm = BitmapFactory.decodeResource(resources, R.drawable.maps)

        anim.duration=2500
        anim.interpolator=LinearInterpolator()
        anim.repeatCount = ValueAnimator.INFINITE
        anim.repeatMode = ValueAnimator.REVERSE



    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        anim.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        anim.end()
    }

    fun setD(d: Float) {
        this.d = d
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var centerX=width/2f
        var centerY=height/2f

        var x=centerX-bm.width/2f
        var y=centerY-bm.height/2f

        //第一遍绘制：上半部分
        canvas?.save()
        canvas?.clipRect(0f, 0f, width.toFloat(), centerY)
        canvas?.drawBitmap(bm, x, y, paint1)
        canvas?.restore()


        //第二遍绘制：下半部分
        canvas?.save()
        if (d < 90f) {
            canvas?.clipRect(0f, centerY, width.toFloat(), height.toFloat())
        }else{
            canvas?.clipRect(0f, 0f, width.toFloat(), centerY)
        }
        cam.save()
        cam.rotateX(d)
        canvas?.translate(centerX, centerY)
        cam.applyToCanvas(canvas)
        canvas?.translate(-centerX, -centerY)
        cam.restore()

        canvas?.drawBitmap(bm, x, y, paint1)
        canvas?.restore()




    }

}