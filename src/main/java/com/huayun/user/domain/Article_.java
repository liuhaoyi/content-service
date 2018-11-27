package com.huayun.user.domain;

import java.io.Serializable;

public class Article_ implements Serializable {

    public Article_(String id, String title, String img, String modifyDatetime) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.modifyDatetime = modifyDatetime;
    }

    private String id;

    private String title;
    private String img;

    private String modifyDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(String modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }
}
