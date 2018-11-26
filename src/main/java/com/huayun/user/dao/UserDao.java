package com.huayun.user.dao;

import com.huayun.article.domain.Article;
import com.huayun.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User,String> {

    User findUserByLoginNameAndPhoneAndUserNo(String loginName,String phone,String userNo);

    User findUserByLoginNameAndUserNo(String loginName,String userNo);

    Page<User> findUsersByNameLikeAndPhoneLikeOrderByNameAsc(String name,String phone,Pageable pageable);

}
