package com.tanner.study.ui.a_view.b_paint.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanner.study.R;
import com.tanner.study.base.BaseFragment;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;

public class Practice13Fragment extends BaseFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aview_bpaint_practice13, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Nullable
    @Override
    public String getTitle() {
        return "ShadowLayerView";
    }
}
