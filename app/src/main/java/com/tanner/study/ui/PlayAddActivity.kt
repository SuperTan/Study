package com.tanner.study.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import cn.bmob.v3.datatype.BmobDate
import cn.bmob.v3.listener.SaveListener
import com.tanner.study.R
import com.tanner.study.base.BaseActivity
import com.tanner.study.model.Play
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.activity_play_add.*
import java.text.SimpleDateFormat
import java.util.*

class PlayAddActivity : BaseActivity() {


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateBar(Color.BLACK)
//        var date=SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        var date = SimpleDateFormat("yyyy-MM-dd").format(Date())
        var time = SimpleDateFormat("HH:mm:ss").format(Date())
        Log.e(TAG, date)
        id_play_date.setText(date)
        id_play_time.setText(time)
        id_play_add.setOnClickListener {
            var play = Play()
            play.content = id_play_content.text.toString()
            play.desc = id_play_desc.text.toString()
//            play.date2 = BmobDate(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(id_play_date.text.toString()))
            play.date = BmobDate(SimpleDateFormat("yyyy-MM-dd").parse(id_play_date.text.toString()))
            play.time = BmobDate(SimpleDateFormat("HH:mm:ss").parse(id_play_time.text.toString()))
            var r = when {
                id_play_remind_no.isChecked -> false
                id_play_remind_yes.isChecked -> true
                else -> false
            }
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
                    MyUtil.showMsg("添加成功")
                    finish()
                }

                override fun onFailure(p0: Int, p1: String?) {
                    MyUtil.showMsg("添加失败")
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
