package com.tanner.study.ui.a_view.f_anim.widget

import android.content.Context
import android.graphics.Path
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.support.v4.view.animation.PathInterpolatorCompat
import android.util.AttributeSet
import android.view.animation.*
import android.widget.LinearLayout
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.aview_fanim_practice07.view.*


class Practice07Interpolator : LinearLayout {

    var interpolators = arrayOfNulls<Interpolator>(13)
    var interpolatorPath: Path

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        interpolatorPath = Path()
        interpolatorPath.lineTo(0.25f, 0.25f)
        interpolatorPath.moveTo(0.25f, 1.5f)
        interpolatorPath.lineTo(1f, 1f)
        interpolators[0] = AccelerateDecelerateInterpolator()
        interpolators[1] = LinearInterpolator()
        interpolators[2] = AccelerateInterpolator()
        interpolators[3] = DecelerateInterpolator()
        interpolators[4] = AnticipateInterpolator()
        interpolators[5] = OvershootInterpolator()
        interpolators[6] = AnticipateOvershootInterpolator()
        interpolators[7] = BounceInterpolator()
        interpolators[8] = CycleInterpolator(0.5f)
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath)
        interpolators[10] = FastOutLinearInInterpolator()
        interpolators[11] = FastOutSlowInInterpolator()
        interpolators[12] = LinearOutSlowInInterpolator()


    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt.setOnClickListener {
            imageView.animate()
                    .translationX(MyUtil.dpToPixel(150f))
                    .setDuration(600L)
                    .setInterpolator(interpolators[interpolatorSpinner.selectedItemPosition])
                    .withEndAction({
                        imageView.postDelayed({
                            imageView.translationX = 0f
                        }, 500L)

                    })
        }

    }


}