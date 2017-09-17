package com.tanner.study.ui.a_view.d_canvas

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.tanner.study.R
import com.tanner.study.adapter.CustomViewFragmentPagerAdapter
import com.tanner.study.base.BaseActivity
import com.tanner.study.base.BaseFragment
import com.tanner.study.ui.a_view.d_canvas.fragment.*
import kotlinx.android.synthetic.main.a_view_dcanvas.*
import java.util.*

/**
 * Created by Tanner on 2017/9/14.
 */
class AviewDcanvasActivity : BaseActivity() {
    internal var mData: ArrayList<BaseFragment> = ArrayList<BaseFragment>()

    override fun getActivityContext(): Context {
        return this
    }

    override fun loadViewLayout() {
        setContentView(R.layout.a_view_dcanvas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStateBar(Color.BLUE)
        mData.add(Practice01Fragment())
        mData.add(Practice02Fragment())
        mData.add(Practice03Fragment())
        mData.add(Practice04Fragment())
        mData.add(Practice05Fragment())
        mData.add(Practice06Fragment())
        mData.add(Practice07Fragment())
        mData.add(Practice08Fragment())
        mData.add(Practice09Fragment())
        mData.add(Practice10Fragment())
        mData.add(Practice11Fragment())
        mData.add(Practice12Fragment())
        mData.add(Practice13Fragment())
        mData.add(Practice14Fragment())
        var mAdapter: CustomViewFragmentPagerAdapter = CustomViewFragmentPagerAdapter(supportFragmentManager, mData)
        id_custom_view_viewpager.adapter=mAdapter
        id_custom_view_tabs.setupWithViewPager(id_custom_view_viewpager)
    }

}