package com.huayun.user.service;

import com.huayun.article.domain.Article;
import com.huayun.user.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    User login(String loginName, String phone, String userNo);

    User login(String loginName,String userNo);

    User add(User user);

    Page<User> query(String name, String phone,int currentPage, int pageSize);

    boolean remove(String[] ids);
}
