package com.huayun.article.domain;

//import org.jboss.logging.Field;
//import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BigCatalog")
public class BigCatalog implements Serializable {

    @Id
    private String id;

    //标题
    @Column(length = 500)
    private String title;

    //图片
    @Column(length = 500)
    private String img;

    //类型；
    @Column(length = 500)
    private String catalog;

    @Column(columnDefinition="int")
    private int seq;

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

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
