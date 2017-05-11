package com.vst.recyclerviewdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vst.recyclerviewdemo.R;
import com.vst.recyclerviewdemo.adapter.MultiltemRvAdapter;
import com.vst.recyclerviewdemo.bean.ChatBean;

import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/20
 * class description:请输入类描述
 */
public class MultiltemRvActivity extends Activity {
    private ArrayList<ChatBean> list;
    private RecyclerView rv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        initView();

    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        MultiltemRvAdapter multiltemRvAdapter = new MultiltemRvAdapter(this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_main.setLayoutManager(linearLayoutManager);
        rv_main.setAdapter(multiltemRvAdapter);
    }

    private void createData() {
        list = new ArrayList<>();
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "where are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "where are you", null, 1));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
    }
}
