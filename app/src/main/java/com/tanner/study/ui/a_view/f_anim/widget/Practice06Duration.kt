package com.tanner.study.ui.a_view.f_anim.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SeekBar
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.aview_fanim_practice06.view.*


class Practice06Duration : LinearLayout {

    var duration:Int=300
    var translationState:Int=0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        durationSb.max=10
        durationSb.progress=1
        durationSb.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration=progress*300
                durationValueTv.text=duration.toString()+"毫秒"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })

        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，同时对多个属性做动画
            when(translationState){
                0 -> imageView.animate().translationX(MyUtil.dpToPixel(100f)).setDuration(duration.toLong())
                1 -> imageView.animate().translationX(0f).setDuration(duration.toLong())
            }
            if(translationState<1){
                translationState++
            }else{
                translationState=0
            }
        }

    }


}