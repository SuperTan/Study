package com.tanner.study.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import com.tanner.study.R;
import com.tanner.study.base.BaseActivity;
import com.tanner.study.util.ColorsUtil;

import butterknife.BindView;

public class ViewActivity extends BaseActivity {

    @BindView(R.id.id_view_conll)
    ConstraintLayout mConstraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int color = ColorsUtil.getColor();
        initStateBar(color);
//        mConstraintLayout.setBackground(ColorsUtil.getColor2());
        mConstraintLayout.setBackgroundColor(color);
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_view);
    }
}
