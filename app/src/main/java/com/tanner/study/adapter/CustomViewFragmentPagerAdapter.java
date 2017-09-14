package com.tanner.study.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.tanner.study.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Tanner on 2017/8/19.
 */

public class CustomViewFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "CustomViewFragmentPager";
    private Context context;
    private ArrayList<BaseFragment> listFragments;

    public CustomViewFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> al) {
        super(fm);
        listFragments=al;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title= listFragments.get(position).getTitle();
        Log.e(TAG, "getPageTitle: "+title );
        return title;
    }

}
