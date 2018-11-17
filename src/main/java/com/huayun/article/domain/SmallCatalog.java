package com.huayun.article.domain;

//import org.jboss.logging.Field;
//import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SmallCatalog")
public class SmallCatalog implements Serializable {

    @Id
    private String id;

    //标题
    @Column(length = 500)
    private String title;

    //图片
    @Column(length = 500)
    private String img;

    @Column(length = 500)
    private String link;

    @Column(columnDefinition="int")
    private int seq;

    //所属大类
    @Column(length = 500)
    private String bigCatalogId;

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

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getBigCatalogId() {
        return bigCatalogId;
    }

    public void setBigCatalogId(String bigCatalogId) {
        this.bigCatalogId = bigCatalogId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
