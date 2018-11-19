package com.huayun.article.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    private String id;

    //标题
    @NotNull
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

    //发布时间；
    @Column(length = 500)
    private String publishDate;

    //修改时间；
    @Column(length = 500)
    private String modifyDatetime;

    //小类；
    @Column(length = 500)
    private String smallCatalog;

    //阅读次数；
    @Column(columnDefinition="long")
    private long readCount;

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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public long getReadCount() {
        return readCount;
    }

    public void setReadCount(long readCount) {
        this.readCount = readCount;
    }
}
