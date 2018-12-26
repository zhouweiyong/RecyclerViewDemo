package com.nze.multilayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zwy
 * @email: zhouweiyong55@163.com
 * @类 说 明:
 * @创建时间：2018/12/25
 */
public class RcvBean {
    private String title;
    private int id;
    private String content;
    private boolean isTitle;

    public RcvBean(String title, int id, String content, boolean isTitle) {
        this.title = title;
        this.id = id;
        this.content = content;
        this.isTitle = isTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public static List<RcvBean> getList() {
        ArrayList<RcvBean> list = new ArrayList<>();
        int index = 1;
        int tmp = 0;
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                tmp = index;
                list.add(new RcvBean("标题" + (index++), i, "", true));
            }
            list.add(new RcvBean("标题" + tmp, i, "content" + i, false));
        }

        return list;
    }
}
