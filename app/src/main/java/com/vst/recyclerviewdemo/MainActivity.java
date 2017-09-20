package com.vst.recyclerviewdemo;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vst.recyclerviewdemo.ui.HeaderRvActivity;
import com.vst.recyclerviewdemo.ui.MultiltemRvActivity;
import com.vst.recyclerviewdemo.ui.OMultilActivity;
import com.vst.recyclerviewdemo.ui.PullUpRvActivity;
import com.vst.recyclerviewdemo.ui.RefreshRvActivity;
import com.vst.recyclerviewlib.CommonAdapter;
import com.vst.recyclerviewlib.MultiItemTypeAdapter;
import com.vst.recyclerviewlib.base.ViewHolder;
import com.vst.recyclerviewlib.widget.Divider;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MultiItemTypeAdapter.OnItemClickListener {
    private List<String> list;
    private RecyclerView rv_main;
    private CommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        String[] arr = new String[]{"Header RecyclerView", "PullUp RecyclerView", "Refresh RecyclerView", "Multiltem RecyclerView", "混合布局"};
        list = Arrays.asList(arr);

        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_main.setLayoutManager(linearLayoutManager);
        Divider divider = new Divider(new ColorDrawable(0xffffff00), LinearLayoutManager.VERTICAL);
        divider.setHeight(2);
        rv_main.addItemDecoration(divider);

        adapter = new CommonAdapter<String>(this, R.layout.item_main, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_main, s);
            }
        };
        rv_main.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, HeaderRvActivity.class);
                break;
            case 1:
                intent.setClass(this, PullUpRvActivity.class);
                break;
            case 2:
                intent.setClass(this, RefreshRvActivity.class);
                break;
            case 3:
                intent.setClass(this, MultiltemRvActivity.class);
                break;
            case 4:
                intent.setClass(this, OMultilActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
