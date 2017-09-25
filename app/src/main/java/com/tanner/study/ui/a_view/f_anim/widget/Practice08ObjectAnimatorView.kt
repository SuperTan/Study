package com.tanner.study.ui.a_view.f_anim.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.tanner.study.util.MyUtil

/**
 * Created by Tanner on 2017/9/25.
 */
class Practice08ObjectAnimatorView : View {

    var radius = MyUtil.dpToPixel(80f)
    var arcRectF = RectF()
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    // TODO 为 progress 添加 getter 和 setter 方法（setter 方法记得加 invalidate()）
    internal var progress: Int=10
//        set(value) {
//            progress = value
//            invalidate()
//        }


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = MyUtil.dpToPixel(40f)
        paint.textAlign = Paint.Align.CENTER
    }

    fun setProgress(value:Int){
        progress=value
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var centerX = width / 2f
        var centerY = height / 2f
        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = MyUtil.dpToPixel(15f)
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)

        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText(progress.toString() + "%", centerX, centerY - ((paint.ascent() + paint.descent()) / 2), paint)

    }
}