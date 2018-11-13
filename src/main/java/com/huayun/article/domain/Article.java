package com.huayun.article.domain;

//import org.jboss.logging.Field;
//import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    //标题
    @Column(length = 500)
    private String title;

    //内容
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;

    //图片；
    @Column(length = 500)
    private String img;

    //编辑；
    @Column(length = 500)
    private String editor;

    //修改时间；
    @Column(length = 500)
    private String modifyDatetime;

    //小类；
    @Column(length = 500)
    private String smallCatalog;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(String modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public String getSmallCatalog() {
        return smallCatalog;
    }

    public void setSmallCatalog(String smallCatalog) {
        this.smallCatalog = smallCatalog;
    }
}
