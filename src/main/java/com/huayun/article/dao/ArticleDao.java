package com.huayun.article.dao;

import com.huayun.article.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ArticleDao extends JpaRepository<Article,String> {

//    @Query("select art from Article art where art.smallCatalog= :smallCatalog and art.modifyDatetime>:time order by art.modifyDatetime desc ")
//    List queryBeforeNewsList(@Param("smallCatalog") String smallCatalog, @Param("time") String time);

    List<Article> findBySmallCatalogAndModifyDatetimeGreaterThanOrderByModifyDatetimeDesc(String smallCatalog,String modifyDatetime);


//    @Query("select art from Article art where art.smallCatalog= :smallCatalog and art.modifyDatetime<:time order by art.modifyDatetime desc ")
//    List queryAfterNewsList(@Param("smallCatalog") String smallCatalog, @Param("time") String time);

    List<Article> findTop5BySmallCatalogAndModifyDatetimeLessThanOrderByModifyDatetimeDesc(String smallCatalog,String modifyDatetime);

    @Query("select art from Article art where art.smallCatalog= :smallCatalog order by modifyDatetime desc")
    List queryRecentList(@Param("smallCatalog") String smallCatalog);

    List<Article> findTop5BySmallCatalogOrderByModifyDatetimeDesc(String smallCatalog);

    Page<Article> findBySmallCatalog(String smallCatalog,Pageable pageable);

    Page<Article> findArticlesBySmallCatalogAndTitleLikeAndPublishDateBetweenOrderByModifyDatetimeDesc(String smallCatalog,String title,String fromDate,String toDate,Pageable pageable);
//    @Query("update Article sc set sc.readCount = sc.readCount + 1  where sc.id=:articleId")

    //浏览计数自增长；
    @Transactional
    @Modifying
    @Query(value = "update Article sc set sc.read_count = sc.read_count + 1  where sc.id=:articleId",nativeQuery=true)
    void increaseArticleReadCount(@Param("articleId") String articleId);

    List<Article> findArticlesByTitleLikeOrderByModifyDatetimeDesc(String title);
}

