package com.tanner.study.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanner.study.R;
import com.tanner.study.ui.PlayAddActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 计划
 */
public class PlayFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @OnClick(R.id.id_play_to_add)
    public  void toAddPlay(){
        Intent intent=new Intent();
        intent.setClass(getActivity(), PlayAddActivity.class);
        getActivity().startActivity(intent);
    }
}
