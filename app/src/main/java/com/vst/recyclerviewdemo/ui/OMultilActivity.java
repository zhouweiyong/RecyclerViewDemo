package com.vst.recyclerviewdemo.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vst.recyclerviewdemo.R;
import com.vst.recyclerviewdemo.bean.ChatBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwy on 2017/9/20.
 * email:16681805@qq.com
 */

public class OMultilActivity extends Activity {

    private RecyclerView rview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_multil);
        initView();
    }

    private void initView() {
        rview = (RecyclerView) findViewById(R.id.rview);
        rview.setLayoutManager(new LinearLayoutManager(this));
        OMultilAdapter adapter = new OMultilAdapter(this,createData());
        rview.setAdapter(adapter);
    }


    private List<ChatBean> createData() {
        ArrayList<ChatBean> list = new ArrayList<>();
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "where are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "where are you", null, 1));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.xiaohei, "xiaobei", "who are you", null, 0));
        list.add(new ChatBean(R.drawable.renma, "rema", "who are you", null, 1));
        return list;
    }

    class OMultilAdapter extends RecyclerView.Adapter<OMultilAdapter.OVH> {
        private List<ChatBean> list;
        private LayoutInflater mInflater;

        public OMultilAdapter(Context context, List<ChatBean> list) {
            this.list = list;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public OVH onCreateViewHolder(ViewGroup parent, int viewType) {
            OVH vh = null;
            switch (viewType) {
                case ChatBean.SEND:
                    vh = new OSendVH(mInflater.inflate(R.layout.chat_send_msg, parent, false));
                    break;
                case ChatBean.COME:
                    vh = new OComeVH(mInflater.inflate(R.layout.chat_come_msg, parent, false));
                    break;
            }
            return vh;
        }

        @Override
        public void onBindViewHolder(OVH holder, int position) {
            holder.bindHolder(list.get(position));
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position).getType();
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        abstract class OVH extends RecyclerView.ViewHolder {

            public OVH(View itemView) {
                super(itemView);
            }

            public abstract void bindHolder(ChatBean chatBean);
        }

        class OSendVH extends OVH {
            private TextView tvNameChat;
            private TextView tvContentChat;

            public OSendVH(View itemView) {
                super(itemView);
                tvNameChat = (TextView) itemView.findViewById(R.id.chat_send_name);
                tvContentChat = (TextView) itemView.findViewById(R.id.chat_send_content);
            }

            @Override
            public void bindHolder(ChatBean chatBean) {
                tvNameChat.setText(chatBean.getName());
                tvContentChat.setText(chatBean.getContent());
            }
        }

        class OComeVH extends OVH {
            private TextView tvContentChat;
            private TextView tvNameChat;

            public OComeVH(View itemView) {
                super(itemView);
                tvContentChat = (TextView) itemView.findViewById(R.id.chat_from_content);
                tvNameChat = (TextView) itemView.findViewById(R.id.chat_from_name);
            }

            @Override
            public void bindHolder(ChatBean chatBean) {
                tvNameChat.setText(chatBean.getName());
                tvContentChat.setText(chatBean.getContent());
            }
        }
    }
}
