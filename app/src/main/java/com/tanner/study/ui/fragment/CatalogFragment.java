package com.tanner.study.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tanner.study.R;
import com.tanner.study.adapter.CatalogAdapter;
import com.tanner.study.model.Catalog;
import com.tanner.study.ui.a_view.CustomViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CatalogFragment extends Fragment {
    @BindView(R.id.id_catalog_list)
    ListView mListView;
    CatalogAdapter mAdapter;
    List<Catalog> mData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        ButterKnife.bind(this, view);
        initData();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(), CustomViewActivity.class));
            }
        });
        return view;
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new Catalog("自定义view1","http://hencoder.com/ui-1-1/"));
        mData.add(new Catalog("自定义view2","http://hencoder.com/ui-1-2/"));
        mAdapter = new CatalogAdapter(getActivity(), mData);
        mListView.setAdapter(mAdapter);
    }
}
