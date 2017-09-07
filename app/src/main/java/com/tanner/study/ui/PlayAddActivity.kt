package com.tanner.study.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import cn.bmob.v3.listener.SaveListener
import com.tanner.study.R
import com.tanner.study.base.BaseActivity
import com.tanner.study.model.Play
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.activity_play_add.*

class PlayAddActivity : BaseActivity() {

//    val mContent: EditText by bindView(R.id.id_play_content)
//    val mDesc: EditText by bindView(R.id.id_play_desc)
//    val mDate: TextView by bindView(R.id.id_play_date)
//    val mTime: TextView by bindView(R.id.id_play_end_time)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateBar(Color.BLACK)
        id_play_add.setOnClickListener {
            var play = Play()
            play.content = id_play_content.text.toString()
            play.desc = id_play_desc.text.toString()
            play.date = id_play_date.text.toString()
            play.time = id_play_end_time.text.toString()
            var r = if (id_play_remind_no.isChecked) true else false
            play.remind = r
            play.complete = false
            var t = when {
                id_play_type_day.isChecked -> "day"
                id_play_type_short.isChecked -> "short"
                id_play_type_long.isChecked -> "long"
                else -> ""
            }
            play.type = t

            play.save(this, object : SaveListener() {
                override fun onSuccess() {
                    finish()
                }

                override fun onFailure(p0: Int, p1: String?) {
                    MyUtil().showMsg("添加失败")
                }
            })
        }
    }

    override fun getActivityContext(): Context {
        return this
    }

    override fun loadViewLayout() {
        setContentView(R.layout.activity_play_add)
    }


}
