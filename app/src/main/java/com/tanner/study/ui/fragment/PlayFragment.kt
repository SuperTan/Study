package com.tanner.study.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tanner.study.R
import com.tanner.study.adapter.CustomViewFragmentPagerAdapter
import com.tanner.study.base.BaseFragment
import com.tanner.study.ui.PlayAddActivity
import kotlinx.android.synthetic.main.fragment_play.*
import kotlinx.android.synthetic.main.fragment_play.view.*
import java.util.*

/**
 * 计划
 */
class PlayFragment : Fragment() {
    val TAG = "PlayFragment"
    var mView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.e(TAG, "onCreate")
        mView = inflater!!.inflate(R.layout.fragment_play, container, false)

        mView?.id_play_to_add?.setOnClickListener {
            activity.startActivity(Intent(activity, PlayAddActivity::class.java))
        }
        return mView

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
        //getData()
    }

    fun getData() {
        Log.e(TAG, "getData")
        var date: ArrayList<BaseFragment> = ArrayList<BaseFragment>()
        date.add(PlayDayFragment())
        date.add(PlayShortFragment())
        date.add(PlayLongFragment())

        mView?.id_play_viewpager?.adapter = CustomViewFragmentPagerAdapter(childFragmentManager, date)
        mView?.id_play_tabs?.setupWithViewPager(id_play_viewpager)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            getData()
        }
    }

}
