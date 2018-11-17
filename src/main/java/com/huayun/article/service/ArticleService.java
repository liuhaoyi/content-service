package com.huayun.article.service;


import com.huayun.article.domain.Article;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {

    List queryBeforeNewsList(String smallCatalog, String time);

    List queryAfterNewsList(String smallCatalog, String time);

    Page<Article> queryArticleBySmallCatalog(String smallCatalog, int currentPage, int pageSize);

    Article addArticle(Article article);

    Article queryArticleById(String id);

}
