package com.tanner.study.ui.a_view.f_anim.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.aview_fanim_practice08.view.*


/**
 * Created by Tanner on 2017/9/25.
 */
class Practice08ObjectAnimatorLayout : RelativeLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        animateBt.setOnClickListener{
            // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
            // 1. 用 ObjectAnimator 创建 Animator 对象
            var animator=ObjectAnimator.ofInt(objectAnimatorView,"progress",0,65)
            animator.duration=1000
            // 2. 用 start() 执行动画
            animator.interpolator=FastOutSlowInInterpolator()
            animator.start()
            // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
        }

    }
}