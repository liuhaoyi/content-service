package com.huayun.article.service.impl;

import com.huayun.article.dao.ArticleDao;
import com.huayun.article.dao.BigCatalogDao;
import com.huayun.article.dao.SmallCatalogDao;
import com.huayun.article.service.ArticleService;
import com.huayun.article.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    public BigCatalogDao bigCatalogDao;

    @Autowired
    public SmallCatalogDao smallCatalogDao;


    @Override
    public List queryBigCatalog() {
        Sort sort = new Sort(Sort.Direction.ASC, "seq");

        List _list =  bigCatalogDao.findAll(sort);
        return _list;
    }

    @Override
    public List querySmallCatalog(String bigCatalog) {
//        return smallCatalogDao.querySmallCatalogsByBigCatalogIdBOrderBySeqAsc(bigCatalog);

        return smallCatalogDao.querySmallCatalogsByBigCatalogIdOrderBySeqAsc(bigCatalog);
    }
}
