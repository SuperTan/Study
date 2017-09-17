package com.tanner.study.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.tanner.study.R;
import com.tanner.study.model.Play;
import com.tanner.study.util.ColorsUtil;
import com.tanner.study.util.MyUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Tanner on 2017/7/24.
 */

public class PlayAdapter extends CommonAdapter<Play> {
    private static final String TAG = "PlayAdapter";
    String action;

    private LocalBroadcastManager mLocalBroadcastManager;
    public PlayAdapter(Context context, List<Play> datas,String action) {

        super(context, datas, R.layout.item_play);
        this.action=action;
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(mContext);
    }

    @Override
    protected void convert(ViewHolder viewHolder, final Play item) {
        final int index = position;
        CheckBox content = viewHolder.getView(R.id.id_item_play_content);
        content.setText(item.getContent());
        content.setTextColor(ColorsUtil.getColor());
        content.setChecked(false);
        content.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    item.setComplete(true);
                    item.update(mContext, item.getObjectId(), new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            Intent intent = new Intent(action);
                            intent.putExtra("g",item.getGroup() );
                            intent.putExtra("i",index );
                            mLocalBroadcastManager.sendBroadcast(intent);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            MyUtil.INSTANCE.showMsg("更新失败");
                        }
                    });
                }
            }
        });

        TextView time = viewHolder.getView(R.id.id_item_play_time);
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
