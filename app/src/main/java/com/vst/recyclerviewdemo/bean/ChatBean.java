package com.vst.recyclerviewdemo.bean;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/12/28
 * class description:请输入类描述
 */
public class ChatBean {
    public final static int SEND = 0;
    public final static int COME = 1;
    private int icon;
    private String name;
    private String content;
    private String createDate;
    private int type;//send:0,come:1

    public ChatBean(int icon, String name, String content, String createDate, int type) {
        this.icon = icon;
        this.name = name;
        this.content = content;
        this.createDate = createDate;
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
