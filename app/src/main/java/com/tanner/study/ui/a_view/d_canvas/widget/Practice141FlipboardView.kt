package com.tanner.study.ui.a_view.d_canvas.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.tanner.study.R


class Practice141FlipboardView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var camera = Camera()
    internal var degree: Int = 0
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps)

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = getWidth() / 2
        val centerY = getHeight() / 2
        val x = centerX - bitmapWidth / 2
        val y = centerY - bitmapHeight / 2

        // 第一遍绘制：上半部分
        canvas.save()
        canvas.clipRect(0, 0, getWidth(), centerY)
        canvas.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas.restore()

        // 第二遍绘制：下半部分
        canvas.save()

        if (degree < 90) {
            canvas.clipRect(0, centerY, getWidth(), getHeight())
        } else {
            canvas.clipRect(0, 0, getWidth(), centerY)
        }
        camera.save()
        camera.rotateX(degree.toFloat())
        canvas.translate(centerX.toFloat(), centerY.toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-centerX.toFloat(), -centerY.toFloat())
        camera.restore()

        canvas.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas.restore()
    }
}