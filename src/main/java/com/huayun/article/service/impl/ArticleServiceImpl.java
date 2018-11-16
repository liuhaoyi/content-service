package com.huayun.article.service.impl;

import com.huayun.article.dao.ArticleDao;
import com.huayun.article.domain.Article;
import com.huayun.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<Article> queryArticleBySmallCatalog(String smallCatalog, int currentPage, int pageSize) {
        Page<Article> _page = articleDao.findBySmallCatalog(smallCatalog,new PageRequest(currentPage,pageSize, Sort.Direction.DESC,"modifyDatetime"));
        return _page;
    }

    @Override
    public Article addArticle(Article article) {
        return articleDao.save(article);
    }

}
