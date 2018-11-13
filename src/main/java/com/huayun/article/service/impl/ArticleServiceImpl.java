package com.huayun.article.service.impl;

import com.huayun.article.dao.ArticleDao;
import com.huayun.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl  implements ArticleService{

    @Autowired
    public ArticleDao articleDao;

    @Override
    public List queryBeforeNewsList(String smallCatalog, String time) {
        if(null==time || "".equals(time)){
            //查询最近10条数据；
            return articleDao.queryRecentList(smallCatalog);
        }else{
            //查询当前时间点前的最新10条数据；
            return articleDao.queryBeforeNewsList(smallCatalog,time);
        }
    }

    @Override
    public List queryAfterNewsList(String smallCatalog, String time) {
        if(null==time || "".equals(time)){
            //查询最近10条数据；
            return articleDao.queryRecentList(smallCatalog);
        }else{
            //查询当前时间点前的最新10条数据；
            return articleDao.queryBeforeNewsList(smallCatalog,time);
        }
    }

}
