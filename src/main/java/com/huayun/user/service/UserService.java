package com.huayun.user.service;

import com.huayun.user.domain.User;

import java.util.List;

public interface UserService {
    List  queryUserList();

    User login(String loginName, String phone, String userNo);
}
