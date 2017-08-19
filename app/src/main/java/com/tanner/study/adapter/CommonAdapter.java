package com.tanner.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Tanner on 2017/2/15.
 * 通用adapter
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private static final String TAG = "CommonAdapter";
    protected LayoutInflater mInflater;
    protected List<T> mDatas;
    protected Context mContext;
    protected int position;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        position=i;
        ViewHolder holder = ViewHolder.get(mContext, view, viewGroup, layoutId, i);
        convert(holder, getItem(i));

        return holder.getConvertView();
    }

    public int getPosition() {
        return position;
    }

    protected abstract void convert(ViewHolder viewHolder, T item);

}
