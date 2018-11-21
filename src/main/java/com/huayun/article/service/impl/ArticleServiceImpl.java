package com.huayun.article.service.impl;

import com.huayun.article.dao.ArticleDao;
import com.huayun.article.domain.Article;
import com.huayun.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.T;


@Service
public class ArticleServiceImpl  implements ArticleService{

    @Autowired
    public ArticleDao articleDao;

    @Override
    public List queryBeforeNewsList(String smallCatalog, String time) {
        if(null==time || "".equals(time)){
            //查询最近10条数据；
//            return articleDao.queryRecentList(smallCatalog);
            return articleDao.findTop5BySmallCatalogOrderByModifyDatetimeDesc(smallCatalog);

        }else{
            //查询当前时间点前的最新10条数据；
//            return articleDao.queryBeforeNewsList(smallCatalog,time);
            return articleDao.findBySmallCatalogAndModifyDatetimeGreaterThanOrderByModifyDatetimeDesc(smallCatalog,time);
        }
    }

    @Override
    public List queryAfterNewsList(String smallCatalog, String time) {
        if(null==time || "".equals(time)){
            //查询最近10条数据；
//            return articleDao.queryRecentList(smallCatalog);
            return articleDao.findTop5BySmallCatalogOrderByModifyDatetimeDesc(smallCatalog);

        }else{
            //查询当前时间点前的最新10条数据；
//            return articleDao.queryAfterNewsList(smallCatalog,time);
            return articleDao.findTop5BySmallCatalogAndModifyDatetimeLessThanOrderByModifyDatetimeDesc(smallCatalog,time);
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

    @Override
    public Article updateArticle(Article article) {
        return articleDao.save(article);
    }

    @Override
    public Article queryArticleById(String id) {
        //阅读次数+1；
        articleDao.increaseArticleReadCount(id);
        return articleDao.findById(id).get();
    }

    @Override
    public Page<Article> queryArticleList(String smallCatalog, String title, String fromDate, String toDate,int currentPage,int pageSize) {
        Page<Article> _page =  articleDao.findArticlesBySmallCatalogAndTitleLikeAndPublishDateBetweenOrderByModifyDatetimeDesc(smallCatalog,title,fromDate,toDate,new PageRequest(currentPage,pageSize, Sort.Direction.DESC,"modifyDatetime"));
        return _page;
    }

    @Override
    public List<Article> search(String title) {
        return articleDao.findArticlesByTitleLikeOrderByModifyDatetimeDesc(title);
    }

    @Override
    public boolean remove(String[] ids) {
        try {
            for(String id:ids){
                articleDao.deleteById(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
