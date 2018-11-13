package com.huayun.article.dao;

import com.huayun.article.domain.BigCatalog;
import com.huayun.article.domain.SmallCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SmallCatalogDao extends JpaRepository<SmallCatalog,String> {
    List querySmallCatalogsByBigCatalogId(String bigCatalogId);
}
