package com.tanner.study.ui.a_view.a_base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.tanner.study.R;
import com.tanner.study.adapter.CustomViewFragmentPagerAdapter;
import com.tanner.study.base.BaseActivity;
import com.tanner.study.ui.a_view.a_base.fragment.Practice01Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice02Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice03Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice04Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice05Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice06Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice07Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice08Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice09Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice10Fragment;
import com.tanner.study.ui.a_view.a_base.fragment.Practice11Fragment;

import java.util.ArrayList;

import butterknife.BindView;

public class AviewAbaseActivity extends BaseActivity {

    @BindView(R.id.id_custom_view_tabs)
    TabLayout mTabLayout;
    @BindView(R.id.id_custom_view_viewpager)
    ViewPager mViewPager;

    CustomViewFragmentPagerAdapter mAdapter;
    ArrayList<Fragment> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStateBar(Color.BLUE);
        mData = new ArrayList<>();
        Practice01Fragment practice01Fragment = new Practice01Fragment();
        mData.add(practice01Fragment);
        mData.add(new Practice02Fragment());
        mData.add(new Practice03Fragment());
        mData.add(new Practice04Fragment());
        mData.add(new Practice05Fragment());
        mData.add(new Practice06Fragment());
        mData.add(new Practice07Fragment());
        mData.add(new Practice08Fragment());
        mData.add(new Practice09Fragment());
        mData.add(new Practice10Fragment());
        mData.add(new Practice11Fragment());
        mAdapter = new CustomViewFragmentPagerAdapter(getSupportFragmentManager(),mData );
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.a_view_abase);
    }
}
