package com.tanner.study.ui;

import android.content.Context;
import android.os.Bundle;

import com.tanner.study.R;
import com.tanner.study.base.BaseActivity;

public class CatalogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_catalog);
    }
}
