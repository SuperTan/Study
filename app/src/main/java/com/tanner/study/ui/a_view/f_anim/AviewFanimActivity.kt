package com.tanner.study.ui.a_view.f_anim

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.tanner.study.R
import com.tanner.study.adapter.CustomViewFragmentPagerAdapter
import com.tanner.study.base.BaseActivity
import com.tanner.study.base.BaseFragment
import com.tanner.study.ui.a_view.f_anim.fragment.*
import kotlinx.android.synthetic.main.a_view_fanim.*
import java.util.*

class AviewFanimActivity : BaseActivity() {
    internal var mData: ArrayList<BaseFragment> = ArrayList<BaseFragment>()

    override fun getActivityContext(): Context {
        return  this
    }

    override fun loadViewLayout() {
        setContentView(R.layout.a_view_fanim)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateBar(Color.BLUE)
        initStateBar(Color.BLUE)
        mData.add(Practice01Fragment())
        mData.add(Practice02Fragment())
        mData.add(Practice03Fragment())
        mData.add(Practice04Fragment())
        mData.add(Practice05Fragment())
        mData.add(Practice06Fragment())
        mData.add(Practice07Fragment())
        mData.add(Practice08Fragment())
        var mAdapter: CustomViewFragmentPagerAdapter = CustomViewFragmentPagerAdapter(supportFragmentManager, mData)
        id_custom_view_viewpager.adapter=mAdapter
        id_custom_view_tabs.setupWithViewPager(id_custom_view_viewpager)
    }
}
