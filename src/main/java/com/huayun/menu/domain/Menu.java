package com.huayun.menu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    private String id;
    @Column(length = 500)
    private String path;
    @Column(length = 500)
    private String locale;
    @Column(length = 500)
    private String icon;

//    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="menu")


    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
    @JoinColumn(name="menu_id")//在menu_item表增加一个外键列来实现一对多的单向关联
    private List<MenuItem> children= new ArrayList<MenuItem>();


//    "path": "/news",
//            "name": "炼化新闻",
//            "locale": "menu.forums",
//            "icon": 'usergroup-add',


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }
}
