package com.vst.recyclerviewdemo.adapter;

import android.content.Context;

import com.vst.recyclerviewdemo.bean.ChatBean;
import com.vst.recyclerviewlib.MultiItemTypeAdapter;

import java.util.List;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/29
 * class description:请输入类描述
 */
public class MultiltemRvAdapter extends MultiItemTypeAdapter<ChatBean> {
    public MultiltemRvAdapter(Context context, List<ChatBean> datas) {
        super(context, datas);
        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComeItemDelagate());
    }
}
