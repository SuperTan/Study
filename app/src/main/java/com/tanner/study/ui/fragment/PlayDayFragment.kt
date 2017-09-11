package com.tanner.study.ui.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.datatype.BmobDate
import cn.bmob.v3.listener.FindListener
import com.tanner.study.R
import com.tanner.study.adapter.PlayAdapter
import com.tanner.study.model.Play
import com.tanner.study.util.MyUtil
import java.text.SimpleDateFormat
import java.util.*


class PlayDayFragment : Fragment() {
    val TAG = "PlayDayFragment"

    companion object {
        val LOCAL_BROADCAST: String = "com.tanner.study.LOCAL_BROADCAST"
        var mDataO: ArrayList<Play>? = ArrayList<Play>()
        var mDataT: ArrayList<Play>? = ArrayList<Play>()
        var mDataN: ArrayList<Play>? = ArrayList<Play>()

        var mFlgO: Boolean? = false
        var mFlgT: Boolean? = false
        var mFlgN: Boolean? = false
        var mContext: Context? = null

        var mView: View? = null
    }




    var mlbm: LocalBroadcastManager? = null
    var mlr: localReceiver? = null
    var mif: IntentFilter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
        mContext = activity
        mlbm = LocalBroadcastManager.getInstance(mContext)
        mlr = localReceiver()
        mif = IntentFilter()

        mif!!.addAction(LOCAL_BROADCAST)
        mlbm!!.registerReceiver(mlr, mif)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(R.layout.fragment_play_day, container, false)

        Log.e(TAG, "onCreateView")
        return mView
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
                mDataO = p0 as ArrayList<Play>?
                mDataO!!.forEach {
                    it.group = "O"
                }

                mFlgO = true
                setData()
            }

            override fun onError(p0: Int, p1: String?) {
                mFlgO = true
                setData()
                Log.e(TAG, p1)
            }
        })


        //2 查询今天的数据  大于今天凌晨 小于今天24点
        val calendarT = Calendar.getInstance()
        calendarT.set(calendarT.get(Calendar.YEAR), calendarT.get(Calendar.MONTH), calendarT.get(Calendar.DAY_OF_MONTH), 23, 59, 59)
        val tDateMax = calendarT.time
        Log.e(TAG, "tDateMin " + date)
        Log.e(TAG, "tDateMax " + tDateMax.toString())
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
                mDataT = p0 as ArrayList<Play>?
                mDataT!!.forEach {
                    it.group = "T"
                }
                mFlgT = true
                setData()
            }

            override fun onError(p0: Int, p1: String?) {
                mFlgT = true
                setData()
                Log.e(TAG, p1)
            }
        })


        //3 查询接下来7天的数据 大于明天 小于7天后
        val calendarNMin = Calendar.getInstance()
        val calendarNMax = Calendar.getInstance()
        calendarNMin.set(calendarNMin.get(Calendar.YEAR), calendarNMin.get(Calendar.MONTH), calendarNMin.get(Calendar.DAY_OF_MONTH), 23, 59, 59)
        calendarNMax.set(calendarNMax.get(Calendar.YEAR), calendarNMax.get(Calendar.MONTH), calendarNMax.get(Calendar.DAY_OF_MONTH) + 7, 23, 59, 59)
        val tDateNMin = calendarNMin.time
        val tDateNMax = calendarNMax.time
        Log.e(TAG, "tDateNMin " + tDateNMin)
        Log.e(TAG, "tDateNMax " + tDateNMax.toString())
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
                mDataN = p0 as ArrayList<Play>?
                mDataN!!.forEach {
                    it.group = "N"
                }
                mFlgN = true
                setData()
            }

            override fun onError(p0: Int, p1: String?) {
                mFlgN = true
                setData()
                Log.e(TAG, p1)
            }
        })
    }

    fun setData() {
        if (!(mFlgO!! && mFlgT!! && mFlgN!!)) {
            return
        }

        if (mDataO!!.size > 0) {
            mView?.findViewById(R.id.id_play_day_overdue_ll)?.visibility = View.VISIBLE
        } else {
            mView?.findViewById(R.id.id_play_day_overdue_ll)?.visibility = View.GONE
        }
        var lvo:ListView=mView?.findViewById(R.id.id_play_day_overdue) as ListView
        lvo.adapter=PlayAdapter(mContext, mDataO)
        MyUtil.setListViewHeightBasedOnChildren(lvo)

        if (mDataT!!.size > 0) {
            mView?.findViewById(R.id.id_play_day_today_ll)?.visibility = View.VISIBLE
        } else {
            mView?.findViewById(R.id.id_play_day_today_ll)?.visibility = View.GONE
        }

        var lvt:ListView=mView?.findViewById(R.id.id_play_day_today) as ListView
        lvt.adapter=PlayAdapter(mContext, mDataT)
        MyUtil.setListViewHeightBasedOnChildren(lvt)

        if (mDataN!!.size > 0) {
            mView?.findViewById(R.id.id_play_day_next_ll)?.visibility = View.VISIBLE
        } else {
            mView?.findViewById(R.id.id_play_day_next_ll)?.visibility = View.GONE
        }

        var lvn:ListView=mView?.findViewById(R.id.id_play_day_next) as ListView
        lvn.adapter=PlayAdapter(mContext, mDataN)
        MyUtil.setListViewHeightBasedOnChildren(lvn)
    }

    class localReceiver : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            var action = p1!!.action
            if (!action.equals(LOCAL_BROADCAST)) {
                return
            }
            var s = p1.extras.getString("g")
            var index = p1.extras.getInt("i")
            when (s) {
                "O" -> PlayDayFragment.mDataO!!.removeAt(index)
                "T" -> PlayDayFragment.mDataT!!.removeAt(index)
                "N" -> PlayDayFragment.mDataN!!.removeAt(index)
            }
            PlayDayFragment().setData()
//            var s=p1.extras.getString("")
//            when(s){
//                ""->
//            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mlbm!!.unregisterReceiver(mlr)
    }
}
