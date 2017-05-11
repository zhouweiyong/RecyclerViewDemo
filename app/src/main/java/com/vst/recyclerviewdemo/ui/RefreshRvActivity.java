package com.vst.recyclerviewdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.vst.recyclerviewdemo.R;
import com.vst.recyclerviewlib.CommonAdapter;
import com.vst.recyclerviewlib.PullUpAdapter;
import com.vst.recyclerviewlib.base.ViewHolder;

import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/28
 * class description:请输入类描述
 */
public class RefreshRvActivity extends Activity implements PullToRefreshBase.OnRefreshListener2 {

    private CommonAdapter<String> adapter;
    private ArrayList<String> list;
    private CommonAdapter<String> commonAdapter;
    private PullUpAdapter<String> pullUpAdapter;
    private int index;
    private PullToRefreshRecyclerView rv_refresh;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("content" + i);
            index = i;
        }

        rv_refresh = (PullToRefreshRecyclerView) findViewById(R.id.rv_refresh);
        rv_refresh.setMode(PullToRefreshBase.Mode.BOTH);
        rv_refresh.setOnRefreshListener(this);
        recyclerView = rv_refresh.getRefreshableView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        commonAdapter = new CommonAdapter<String>(this, R.layout.item_main, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_main, s);
            }
        };
        recyclerView.setAdapter(commonAdapter);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              rv_refresh.setRefreshing(true);
            }
        },200);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        Toast.makeText(this, "下拉。。。", Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rv_refresh.onRefreshComplete();
            }
        },3000);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        Toast.makeText(this, "上拉。。。", Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rv_refresh.onRefreshComplete();
            }
        },3000);
    }

    private Handler handler = new Handler();
}
