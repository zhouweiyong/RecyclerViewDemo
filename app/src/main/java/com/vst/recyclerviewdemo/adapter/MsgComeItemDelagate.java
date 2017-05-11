package com.vst.recyclerviewdemo.adapter;

import com.vst.recyclerviewdemo.R;
import com.vst.recyclerviewdemo.bean.ChatBean;
import com.vst.recyclerviewlib.base.ItemViewDelegate;
import com.vst.recyclerviewlib.base.ViewHolder;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/29
 * class description:请输入类描述
 */
public class MsgComeItemDelagate implements ItemViewDelegate<ChatBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.chat_come_msg;
    }

    @Override
    public boolean isForViewType(ChatBean item, int position) {
        return item.getType()==1;
    }

    @Override
    public void convert(ViewHolder holder, ChatBean chatBean, int position) {
        holder.setText(R.id.chat_from_content, chatBean.getContent());
        holder.setText(R.id.chat_from_name, chatBean.getName());
        holder.setImageResource(R.id.chat_from_icon, chatBean.getIcon());
    }
}
