package com.tanner.study.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tanner.study.R;
import com.tanner.study.model.Play;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by Tanner on 2017/7/24.
 */

public class PlayAdapter extends CommonAdapter<Play> {
    private static final String TAG = "PlayAdapter";
    public PlayAdapter(Context context, List<Play> datas) {
        super(context, datas, R.layout.item_play);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Play item) {
        TextView content = viewHolder.getView(R.id.id_item_play_content);
        content.setText(item.getContent());

        TextView time = viewHolder.getView(R.id.id_item_play_time);
        BmobDate bTime = item.getTime();
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String nowDate = format1.format(new Date());
        String mDate= null;
        try {
            mDate = format1.format(format1.parse(item.getDate().getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String tTime= null;
        Calendar calendar=Calendar.getInstance();
        try {
            calendar.setTime(format2.parse(item.getTime().getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tTime=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);


        int i = mDate.compareTo(nowDate);
        if (i > 0) {
            //未来计划
            time.setText(mDate);
        } else if (i == 0) {
            //今天
            time.setText(tTime);
        } else {
            //过期
            time.setText(mDate);
        }

        TextView desc = viewHolder.getView(R.id.id_item_play_desc);
        desc.setText(item.getDesc());
        TextView remind = viewHolder.getView(R.id.id_item_play_remind);
        if(item.getRemind()){
            remind.setVisibility(View.VISIBLE);
        }else{
            remind.setVisibility(View.INVISIBLE);
        }
    }
}
