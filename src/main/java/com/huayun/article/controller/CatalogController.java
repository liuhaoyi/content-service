package com.huayun.article.controller;

import com.huayun.article.domain.BigCatalog;
import com.huayun.article.service.ArticleService;
import com.huayun.article.service.CatalogService;
import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class CatalogController extends AbstractController{

    @Autowired
    public CatalogService catalogService;

    @ResponseBody
    @RequestMapping(value = "/queryBigCatalog", method = RequestMethod.GET)
    public ResultObject queryBigCatalog(){
        return this.success(catalogService.queryBigCatalog());
    }

    @ResponseBody
    @RequestMapping(value = "/querySmallCatalog", method = RequestMethod.GET)
    public ResultObject queryBeforeNewsList(@RequestParam("bigCatalog")String bigCatalog){
        return this.success(catalogService.querySmallCatalog(bigCatalog));
    }

}
