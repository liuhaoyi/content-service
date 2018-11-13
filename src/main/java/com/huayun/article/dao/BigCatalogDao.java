package com.huayun.article.dao;

import com.huayun.article.domain.Article;
import com.huayun.article.domain.BigCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BigCatalogDao extends JpaRepository<BigCatalog,String> {

}
