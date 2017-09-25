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
import com.tanner.study.ui.WebViewActivity;
import com.tanner.study.ui.a_view.a_base.AviewAbaseActivity;
import com.tanner.study.ui.a_view.b_paint.AviewBpaintActivity;
import com.tanner.study.ui.a_view.c_paint.AviewCpaintActivity;
import com.tanner.study.ui.a_view.d_canvas.AviewDcanvasActivity;
import com.tanner.study.ui.a_view.e_order.AviewEorderActivity;
import com.tanner.study.ui.a_view.f_anim.AviewFanimActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 目录
 */
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
                startActivity(new Intent(getActivity(), mData.get((int) l).getActivity()));
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, mData.get((int) l).getUrl());
                startActivity(intent);
                return true;
            }
        });
        return view;
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new Catalog("自定义view1", "http://hencoder.com/ui-1-1/", AviewAbaseActivity.class));
        mData.add(new Catalog("自定义view2", "http://hencoder.com/ui-1-2/", AviewBpaintActivity.class));
        mData.add(new Catalog("自定义view3", "http://hencoder.com/ui-1-3/", AviewCpaintActivity.class));
        mData.add(new Catalog("自定义view4", "http://hencoder.com/ui-1-4/", AviewDcanvasActivity.class));
        mData.add(new Catalog("自定义view5", "http://hencoder.com/ui-1-5/", AviewEorderActivity.class));
        mData.add(new Catalog("自定义view6", "http://hencoder.com/ui-1-6/", AviewFanimActivity.class));
        mAdapter = new CatalogAdapter(getActivity(), mData);
        mListView.setAdapter(mAdapter);
    }
}
