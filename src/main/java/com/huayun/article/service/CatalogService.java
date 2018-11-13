package com.huayun.article.service;


import java.util.List;

public interface CatalogService {

    List queryBigCatalog();

    List querySmallCatalog(String bigCatalog);

}
