package com.huayun.user.service.impl;

import com.huayun.user.dao.UserDao;
import com.huayun.user.domain.User;
import com.huayun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public List queryUserList() {
        return null;
    }

    @Override
    public User login(String loginName, String phone, String userNo) {
        User _user = userDao.findUserByLoginNameAndPhoneAndUserNo(loginName,phone,userNo);
        return _user;
    }
}
