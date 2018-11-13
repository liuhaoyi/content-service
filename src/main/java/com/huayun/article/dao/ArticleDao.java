package com.huayun.article.dao;

import com.huayun.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArticleDao extends JpaRepository<Article,String> {

    @Query("select art from Article art where art.smallCatalog= :smallCatalog and art.modifyDatetime>:time ")
    List queryBeforeNewsList(@Param("smallCatalog") String smallCatalog, @Param("time") String time);

    @Query("select art from Article art where art.smallCatalog= :smallCatalog and art.modifyDatetime<:time ")
    List queryBeforeAfterList(@Param("smallCatalog") String smallCatalog, @Param("time") String time);


    @Query("select art from Article art where art.smallCatalog= :smallCatalog order by modifyDatetime desc")
    List queryRecentList(@Param("smallCatalog") String smallCatalog);

}
