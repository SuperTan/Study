package com.tanner.study.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Tanner on 2017/8/19.
 */

public class CustomViewFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<Fragment> listFragments;

    public CustomViewFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> al) {
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
        return "自定义"+position;
    }
}
