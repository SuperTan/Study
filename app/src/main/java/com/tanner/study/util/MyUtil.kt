package com.tanner.study.util

import android.widget.ListView
import android.widget.Toast
import com.tanner.study.base.MyApplication



/**
 * Created by Tanner on 2017/9/4.
 */
class MyUtil{

    public fun showMsg(msg:String){
        Toast.makeText(MyApplication.instance,msg,Toast.LENGTH_SHORT).show()
    }

    fun setListViewHeightBasedOnChildren(listView: ListView) {

        // 获取ListView对应的Adapter

        val listAdapter = listView.getAdapter() ?: return

        var totalHeight = 0

        for (i in 0..listAdapter.getCount() - 1) { // listAdapter.getCount()返回数据项的数目

            val listItem = listAdapter.getView(i, null, listView)

            listItem.measure(0, 0) // 计算子项View 的宽高

            totalHeight += listItem.getMeasuredHeight() // 统计所有子项的总高度

        }

        val params = listView.getLayoutParams()

        params.height = totalHeight + listView.getDividerHeight() * (listAdapter.getCount() - 1)

        // listView.getDividerHeight()获取子项间分隔符占用的高度

        // params.height最后得到整个ListView完整显示需要的高度

        listView.setLayoutParams(params)

    }
}