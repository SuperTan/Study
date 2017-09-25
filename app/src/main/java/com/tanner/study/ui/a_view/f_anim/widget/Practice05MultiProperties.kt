package com.tanner.study.ui.a_view.f_anim.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.aview_fanim_practice05.view.*

class Practice05MultiProperties : RelativeLayout {

    var flag:Boolean=false
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        imageView.setScaleX(0f)
        imageView.setScaleY(0f)
        imageView.setAlpha(0f)

        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，同时对多个属性做动画
            if(flag){
                imageView.animate().translationX(MyUtil.dpToPixel(100f))
                        .rotation(300f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
            }else{
                imageView.animate().translationX(MyUtil.dpToPixel(0f))
                        .rotation(0f)
                        .scaleX(0f)
                        .scaleY(0f)
                        .alpha(0f)
            }
            flag=!flag
        }
    }


}