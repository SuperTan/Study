package com.tanner.study.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.datatype.BmobDate
import cn.bmob.v3.listener.FindListener
import com.tanner.study.R
import com.tanner.study.adapter.PlayAdapter
import com.tanner.study.model.Play
import com.tanner.study.util.MyUtil
import kotlinx.android.synthetic.main.fragment_play_day.*
import java.text.SimpleDateFormat
import java.util.*



class PlayDayFragment : Fragment() {
    val TAG = "PlayDayFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_play_day, container, false)

        Log.e(TAG, "onCreateView")


        return view
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
        getDate()
    }

    fun getDate() {
        Log.e(TAG, "getDate")
        //查询数据 类型 day

        var query1 = BmobQuery<Play>().addWhereEqualTo("type", "day")
        var query2 = BmobQuery<Play>().addWhereEqualTo("complete", false)
        var format = SimpleDateFormat("yyyy-MM-dd")
        var date = format.format(Date())

        //1 查询已过期的数据
        var queryO1 = BmobQuery<Play>().addWhereLessThan("date", BmobDate(format.parse(date)))
        var queryOs = ArrayList<BmobQuery<Play>>()
        queryOs.add(query1)
        queryOs.add(query2)
        queryOs.add(queryO1)

        var queryOverdue = BmobQuery<Play>()
        queryOverdue.and(queryOs)
        queryOverdue.findObjects(activity, object : FindListener<Play>() {
            override fun onSuccess(p0: MutableList<Play>?) {
                id_play_day_overdue.adapter = PlayAdapter(activity, p0)
                MyUtil().setListViewHeightBasedOnChildren(id_play_day_overdue)
            }

            override fun onError(p0: Int, p1: String?) {
                Log.e(TAG, p1)
            }
        })


        //2 查询今天的数据  大于今天凌晨 小于今天24点
        val calendarT = Calendar.getInstance()
        calendarT.set(calendarT.get(Calendar.YEAR),calendarT.get(Calendar.MONTH),calendarT.get(Calendar.DAY_OF_MONTH),23,59,59)
        val tDateMax = calendarT.time
        Log.e(TAG,"tDateMin "+date)
        Log.e(TAG,"tDateMax "+tDateMax.toString())
        var queryT1 = BmobQuery<Play>().addWhereGreaterThanOrEqualTo("date", BmobDate(format.parse(date)))
        var queryT2 = BmobQuery<Play>().addWhereLessThan("date", BmobDate(tDateMax))
        var queryTs = ArrayList<BmobQuery<Play>>()
        queryTs.add(query1)
        queryTs.add(query2)
        queryTs.add(queryT1)
        queryTs.add(queryT2)

        var queryToday = BmobQuery<Play>()
        queryToday.and(queryTs)
        queryToday.findObjects(activity, object : FindListener<Play>() {
            override fun onSuccess(p0: MutableList<Play>?) {
                id_play_day_today.adapter = PlayAdapter(activity, p0)
                MyUtil().setListViewHeightBasedOnChildren(id_play_day_today)
            }

            override fun onError(p0: Int, p1: String?) {
                Log.e(TAG, p1)
            }
        })


        //3 查询接下来7天的数据 大于明天 小于7天后
        val calendarNMin = Calendar.getInstance()
        val calendarNMax = Calendar.getInstance()
        calendarNMin.set(calendarNMin.get(Calendar.YEAR),calendarNMin.get(Calendar.MONTH),calendarNMin.get(Calendar.DAY_OF_MONTH),23,59,59)
        calendarNMax.set(calendarNMax.get(Calendar.YEAR),calendarNMax.get(Calendar.MONTH),calendarNMax.get(Calendar.DAY_OF_MONTH)+7,23,59,59)
        val tDateNMin = calendarNMin.time
        val tDateNMax = calendarNMax.time
        Log.e(TAG,"tDateNMin "+tDateNMin)
        Log.e(TAG,"tDateNMax "+tDateNMax.toString())
        var queryN1 = BmobQuery<Play>().addWhereGreaterThan("date", BmobDate(tDateNMin))
        var queryN2 = BmobQuery<Play>().addWhereLessThanOrEqualTo("date", BmobDate(tDateNMax))
        var queryNs = ArrayList<BmobQuery<Play>>()
        queryNs.add(query1)
        queryNs.add(query2)
        queryNs.add(queryN1)
        queryNs.add(queryN2)

        var queryNext = BmobQuery<Play>()
        queryNext.and(queryNs)
        queryNext.findObjects(activity, object : FindListener<Play>() {
            override fun onSuccess(p0: MutableList<Play>?) {
                id_play_day_next.adapter = PlayAdapter(activity, p0)
                MyUtil().setListViewHeightBasedOnChildren(id_play_day_next)
            }

            override fun onError(p0: Int, p1: String?) {
                Log.e(TAG, p1)
            }
        })
    }
}
