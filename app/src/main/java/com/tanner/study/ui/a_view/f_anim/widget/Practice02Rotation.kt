package com.tanner.study.ui.a_view.f_anim.widget

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.RelativeLayout
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.aview_fanim_practice01.view.*

class Practice02Rotation : RelativeLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.outlineProvider = MusicOutlineProvider()
        }

        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
            imageView.animate().rotation(100f).rotationX(30f)

        }
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    internal inner class MusicOutlineProvider : ViewOutlineProvider() {
        var path = Path()

        init {
            path.moveTo(0f, MyUtil.dpToPixel(10f))
            path.lineTo(MyUtil.dpToPixel(7f), MyUtil.dpToPixel(2f))
            path.lineTo(MyUtil.dpToPixel(116f), MyUtil.dpToPixel(58f))
            path.lineTo(MyUtil.dpToPixel(116f), MyUtil.dpToPixel(70f))
            path.lineTo(MyUtil.dpToPixel(7f), MyUtil.dpToPixel(128f))
            path.lineTo(0f, MyUtil.dpToPixel(120f))
            path.close()
        }

        override fun getOutline(view: View, outline: Outline) {
            outline.setConvexPath(path)
        }
    }
}