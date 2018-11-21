package com.huayun.article.controller;

import com.huayun.article.domain.Article;
import com.huayun.article.service.ArticleService;
import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import com.huayun.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api")
public class ArticleController extends AbstractController{

    @Autowired
    public ArticleService articleService;

    //读取配置文件中的文件存储路径；
    @Value("${img.location}")
    private String location;

    @ResponseBody
    @RequestMapping(value = "/queryBeforeNewsList", method = RequestMethod.GET)
    public ResultObject queryBeforeNewsList(@RequestParam("smallCatalog")String smallCatalog, @RequestParam("time") String time){
        return this.success(articleService.queryBeforeNewsList(smallCatalog,time));
    }

    @ResponseBody
    @RequestMapping(value = "/queryAfterNewsList", method = RequestMethod.GET)
    public ResultObject queryAfterNewsList(@RequestParam("smallCatalog")String smallCatalog,@RequestParam("time") String time){
        return this.success(articleService.queryAfterNewsList(smallCatalog,time));
    }

    //公用detail表；固定catalog_id='shouyedongtu'
    @ResponseBody
    @RequestMapping(value = "/queryMainPicList", method = RequestMethod.GET)
    public ResultObject queryMainPicList(@RequestParam("smallCatalog") String smallCatalog,
                                         @RequestParam("currentPage") int currentPage,
                                        @RequestParam("pageSize") int pageSize){
        return this.pageDecorator(articleService.queryArticleBySmallCatalog(smallCatalog,currentPage,pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "queryArticleById", method = RequestMethod.GET)
    public ResultObject queryArticleById(@RequestParam("id") String id){
        //每一次查询，阅读次数+1；
        return this.success(articleService.queryArticleById(id));
    }


    @ResponseBody
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResultObject addArticle(Article article) {
        //获取最新事件；
        article.setModifyDatetime(Long.toString(new Date().getTime()));
        //存储图片；
//        data:image/jpg;base64,/9j/4AAQSkZJRgA

        //获取图片类型；
        String img = article.getImg();


        if(null!=img && img.startsWith("data")){
            //图片类型
            String imageType = img.split(";")[0].split("/")[1];
            String imageName = UUID.randomUUID().toString() + "." + imageType;
            String saveImagePath = location + "/" + imageName;
            String images = img.split(",")[1];
            ImageUtils.base664ToImage(images,saveImagePath);
            article.setImg("/api/image/" + imageName);
        }

        return this.success(articleService.addArticle(article));
    }

    //
    @ResponseBody
    @RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
    public ResultObject updateArticle(Article article) {
        //获取最新事件；
        article.setModifyDatetime(Long.toString(new Date().getTime()));
        return this.success(articleService.updateArticle(article));
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
    @RequestMapping(value = "/queryArticleList", method = RequestMethod.GET)
    public ResultObject queryArticleList(
            @RequestParam("smallCatalog") String smallCatalog,
            @RequestParam("title") String title,
            @RequestParam("fromDate") String fromDate,
            @RequestParam("toDate") String toDate,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize){


        //设置默认时间；
        if(null==fromDate || "".equals(fromDate)){
            fromDate = "1900-00-00";
        }
        if(null==toDate || "".equals(toDate)){
            toDate = "3000-00-00";
        }
        return this.pageDecorator(articleService.queryArticleList(smallCatalog,"%" +title+"%",fromDate,toDate,currentPage,pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/removeArticle", method = RequestMethod.POST)
    public ResultObject remove(@RequestBody String[] ids){
        return this.success(articleService.remove(ids));
    }

    //搜索；
    @ResponseBody
    @RequestMapping(value ="/search" , method = RequestMethod.GET)
    public ResultObject search(@RequestParam("title") String title) {
        return  this.success(articleService.search("%" + title + "%"));
    }
}
