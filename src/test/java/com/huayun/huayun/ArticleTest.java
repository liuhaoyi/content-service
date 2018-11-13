package com.huayun.huayun;

import com.huayun.article.dao.ArticleDao;
import com.huayun.article.dao.BigCatalogDao;
import com.huayun.article.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleDao articleDao;

    private BigCatalogDao BigCatalogDao;

//    @Test
//    public void testSaveArticle() throws Exception {
//        Article article =new Article();
//        article.setId("111");
//        article.setTitle("小明");
//        article.setContent("fffooo123");
//        article.setImg("fffooo123");
//
//        article.setEditor("liuhy");
//        articleDao.save(article);
//
////        articleDao.insert(article);
//    }

    @Test
    public void testQueryBigCatalog() throws Exception {

        List _list = articleDao.findAll();
        System.out.println("---");

//        articleDao.insert(article);
    }


//    @Test
//    public void findUserByUserName(){
//        UserEntity user= userDao.findUserByUserName("小明");
//        System.out.println("user is "+user);
//    }
//
//    @Test
//    public void updateUser(){
//        UserEntity user=new UserEntity();
//        user.setId(2l);
//        user.setUserName("天空");
//        user.setPassWord("fffxxxx");
//        userDao.updateUser(user);
//    }
//
//    @Test
//    public void deleteUserById(){
//        userDao.deleteUserById(1l);
//    }
}
