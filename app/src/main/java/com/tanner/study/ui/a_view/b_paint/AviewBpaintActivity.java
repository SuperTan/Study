package com.tanner.study.ui.a_view.b_paint;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.tanner.study.R;
import com.tanner.study.adapter.CustomViewFragmentPagerAdapter;
import com.tanner.study.base.BaseActivity;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice01Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice02Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice03Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice04Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice05Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice06Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice07Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice08Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice09Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice10Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice11Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice12Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice13Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice14Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice15Fragment;
import com.tanner.study.ui.a_view.b_paint.fragment.Practice16Fragment;

import java.util.ArrayList;

import butterknife.BindView;

public class AviewBpaintActivity extends BaseActivity {

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
        mData.add(new Practice01Fragment());
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
        mData.add(new Practice12Fragment());
        mData.add(new Practice13Fragment());
        mData.add(new Practice14Fragment());
        mData.add(new Practice15Fragment());
        mData.add(new Practice16Fragment());
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
        setContentView(R.layout.a_view_bpaint);
    }
}
