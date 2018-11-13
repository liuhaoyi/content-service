package com.huayun.article.service;


import java.util.List;

public interface ArticleService {

    List queryBeforeNewsList(String smallCatalog, String time);

    List queryAfterNewsList(String smallCatalog, String time);
}
