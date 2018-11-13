package com.huayun.article.controller;

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

}
