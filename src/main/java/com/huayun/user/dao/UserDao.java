package com.huayun.user.dao;

import com.huayun.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User,String> {

    User findUserByLoginNameAndPhoneAndUserNo(String loginName,String phone,String userNo);

    User findUserByLoginNameAndUserNo(String loginName,String userNo);
}
