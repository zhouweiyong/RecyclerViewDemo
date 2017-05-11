package com.vst.recyclerviewdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
public class PullUpRvActivity extends Activity implements PullUpAdapter.OnPullUpListener {

    private RecyclerView rv_common;
    private CommonAdapter<String> adapter;
    private ArrayList<String> list;
    private CommonAdapter<String> commonAdapter;
    private PullUpAdapter<String> pullUpAdapter;
    private int index;

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
            index = i;
        }

        rv_common = (RecyclerView) findViewById(R.id.rv_common);
        pullUpAdapter = new PullUpAdapter<String>(rv_common, R.layout.item_main, list) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_main, s);
            }
        };
        pullUpAdapter.setPullUpListener(this);
        rv_common.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_common.setAdapter(pullUpAdapter);

    }

    private Handler handler = new Handler();

    @Override
    public void onBottom(int state) {
        if (pullUpAdapter.getState() != PullUpAdapter.STATE_NO_MORE) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int max = index + 10;
                    for (int i = index; i < max; i++) {
                        list.add("content" + i);
                        index = i;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pullUpAdapter.refresh(list);
                            if (index > 30) {
                                pullUpAdapter.getFooterView().setNoMoreState();
                                pullUpAdapter.setState(PullUpAdapter.STATE_NO_MORE);
                            }
                        }
                    });
                }
            }).start();
        }
    }
}
