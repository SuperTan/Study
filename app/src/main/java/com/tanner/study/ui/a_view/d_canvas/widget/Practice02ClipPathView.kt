package com.tanner.study.ui.a_view.d_canvas.widget

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.tanner.study.R

/**
 * Created by Tanner on 2017/8/19.
 */

class Practice02ClipPathView : View {
    var paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var path1: Path
    var path2: Path
    val bm:Bitmap
    var h:Int
    var w:Int

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {

        bm=BitmapFactory.decodeResource(resources,R.drawable.maps)
        h=bm.height
        w=bm.width

        path1=Path()
        path1.addCircle(w/2f,h/2f,w/3f,Path.Direction.CW)

        path2=Path()
        path2.fillType=Path.FillType.INVERSE_WINDING
        path2.addCircle(w/2f,h/2f+h,w/3f,Path.Direction.CW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setBackgroundColor(Color.parseColor("#ABCDEF"))


        canvas.save()
        canvas.clipPath(path1)
        canvas.drawBitmap(bm,10f,10f,paint)
        canvas.restore()

        canvas.save()
        canvas.clipPath(path2)
        canvas.drawBitmap(bm,10f,10f+h,paint)
        canvas.restore()

        //原图
        canvas.save()
        canvas.drawBitmap(bm,10f,10f+h*2,paint)
        canvas.restore()
    }
}
