package com.huayun.article.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="catalog")
public class Catalog {

    private String id;
    //类别名称；
    private String name;
    //类别；'normal'，'','link'
    private String type;
    //父类；0，表示根；
    private String parentId;
}
