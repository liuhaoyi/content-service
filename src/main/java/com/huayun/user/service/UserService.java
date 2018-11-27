package com.huayun.user.service;

import com.huayun.user.domain.Article_;
import com.huayun.user.domain.Favor;
import com.huayun.user.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    User login(String loginName, String phone, String userNo);

    User login(String loginName,String userNo);

    User add(User user);

    Page<User> query(String name, String phone,int currentPage, int pageSize);

    User queryUserByid(String userId);


    boolean remove(String[] ids);

    Favor favor(Favor favor);

    boolean removeFavor(String userId,String articleId);

    Favor queryFavorByUserIdAndArticleId(String userId,String articleId);


    List<Article_> queryFavorList(String userId);

//    List<Pair> queryFavorAfterNewsList(String userId, String time);


}
