package com.huayun.menu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "MenuItem")
public class MenuItem {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")    private String id;

    @Column(length = 500)
    private String path;

    @Column(length = 500)
    private String name;

    @Column(length = 500)
    private String component;

//    @ManyToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name="menu_id")
//    private Menu menu;

//    path: '/news/article/1',
//    name: '公司要闻',
//    // name: 'news',
//    component: './News/News',


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setMenu(Menu menu) {
//        this.menu = menu;
//    }
}
