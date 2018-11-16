package com.huayun.article.controller;

import com.huayun.article.domain.Article;
import com.huayun.article.service.ArticleService;
import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@Controller
@RequestMapping("api")
public class ArticleController extends AbstractController{

    @Autowired
    public ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/queryBeforeNewsList", method = RequestMethod.GET)
    public ResultObject queryBeforeNewsList(@RequestParam("smallCatalog")String smallCatalog, @RequestParam("time") String time){
        return this.success(articleService.queryBeforeNewsList(smallCatalog,time));
    }

    @ResponseBody
    @RequestMapping(value = "/queryAfterNewsList", method = RequestMethod.GET)
    public ResultObject queryAfterNewsList(@RequestParam("smallCatalog")String smallCatalog,@RequestParam("time") String time){

        return null;
    }

    //公用detail表；固定catalog_id='MailPic'
    @ResponseBody
    @RequestMapping(value = "/queryMainPicList", method = RequestMethod.GET)
    public ResultObject queryMainPicList(){
        //

        return null;
    }

    @ResponseBody
    @RequestMapping(value = "queryNewsById", method = RequestMethod.GET)
    public ResultObject queryNewsById(@RequestParam("id") String id){
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/queryArticleBySmallCatalog", method = RequestMethod.GET)
    public ResultObject queryArticleBySmallCatalog(
            @RequestParam("smallCatalog") String smallCatalog,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize){
        //
        return this.pageDecorator(articleService.queryArticleBySmallCatalog(smallCatalog,currentPage,pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResultObject addArticle(Article article) {
        return this.success(articleService.addArticle(article));
    }

}
