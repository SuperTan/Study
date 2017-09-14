package com.tanner.study.ui.a_view.a_base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanner.study.R;
import com.tanner.study.base.BaseFragment;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;

public class Practice08Fragment extends BaseFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aview_abase_practice08, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Nullable
    @Override
    public String getTitle() {
        return "DrawArcView";
    }
}
