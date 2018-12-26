package com.nze.multilayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zwy
 * @email: zhouweiyong55@163.com
 * @类 说 明:
 * @创建时间：2018/12/25
 */
public class RcvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RcvBean> list;
    private LayoutInflater inflater;

    private final int TYPE_TITLE = 0;
    private final int TYPE_COTENT = 1;

    public RcvAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        list = new ArrayList<>();
    }

    public void setData(List<RcvBean> data) {
        if (list.size() > 0) {
            list.clear();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        RcvBean rcvBean = list.get(position);
        if (rcvBean.isTitle()) {
            return TYPE_TITLE;
        } else {
            return TYPE_COTENT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_TITLE) {
            View titleItemView = inflater.inflate(R.layout.rcv_title, viewGroup, false);
            return new TitleHolder(titleItemView);
        } else {
            View contentItemView = inflater.inflate(R.layout.rcv_content, viewGroup, false);
            return new ContentHolder(contentItemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RcvBean rcvBean = list.get(i);
        if (viewHolder instanceof TitleHolder) {
            TitleHolder titleHolder = (TitleHolder) viewHolder;
            titleHolder.titleTv.setText(rcvBean.getTitle());
        } else {
            ContentHolder contentHolder = (ContentHolder) viewHolder;
            contentHolder.idTv.setText(String.valueOf(rcvBean.getId()));
            contentHolder.contentTv.setText(rcvBean.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ContentHolder extends RecyclerView.ViewHolder {
        public TextView idTv;
        public TextView contentTv;

        public ContentHolder(@NonNull View itemView) {
            super(itemView);
            idTv = itemView.findViewById(R.id.tv_id_rc);
            contentTv = itemView.findViewById(R.id.tv_content_rc);
        }
    }


    static class TitleHolder extends RecyclerView.ViewHolder {
        public TextView titleTv;

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv_title_rt);
        }
    }
}





