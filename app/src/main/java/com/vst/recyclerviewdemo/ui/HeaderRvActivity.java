package com.vst.recyclerviewdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.vst.recyclerviewdemo.R;
import com.vst.recyclerviewlib.CommonAdapter;
import com.vst.recyclerviewlib.PullUpAdapter;
import com.vst.recyclerviewlib.base.ViewHolder;
import com.vst.recyclerviewlib.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/20
 * class description:请输入类描述
 */
public class HeaderRvActivity extends Activity {

    private RecyclerView rv_common;
    private CommonAdapter<String> adapter;
    private ArrayList<String> list;
    private CommonAdapter<String> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_rv);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("content" + i);
        }

        commonAdapter = new CommonAdapter<String>(this, R.layout.item_main, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_main, s);
            }
        };


        rv_common = (RecyclerView) findViewById(R.id.rv_common);
        PullUpAdapter<String> pullUpAdapter = new PullUpAdapter<String>(rv_common, R.layout.item_main, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_main, s);
            }
        };

        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(commonAdapter);
        TextView textView = new TextView(this);
        textView.setText("headereee");
        headerAndFooterWrapper.addHeaderView(textView);

        rv_common.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_common.setAdapter(headerAndFooterWrapper);
    }
}
