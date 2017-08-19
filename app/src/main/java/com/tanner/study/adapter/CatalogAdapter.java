package com.tanner.study.adapter;

import android.content.Context;
import android.widget.TextView;

import com.tanner.study.R;
import com.tanner.study.model.Catalog;

import java.util.List;

/**
 * Created by Tanner on 2017/7/24.
 */

public class CatalogAdapter extends CommonAdapter<Catalog> {
    public CatalogAdapter(Context context, List<Catalog> datas) {
        super(context, datas, R.layout.item_catalog);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Catalog item) {
       TextView txt= viewHolder.getView(R.id.id_item_catalog_txt);
        txt.setText(item.getTitle());
    }
}
