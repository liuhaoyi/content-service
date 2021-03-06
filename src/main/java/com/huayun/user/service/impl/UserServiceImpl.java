package com.huayun.user.service.impl;

import com.huayun.user.dao.FavorDao;
import com.huayun.user.dao.UserDao;
import com.huayun.user.domain.Article_;
import com.huayun.user.domain.Favor;
import com.huayun.user.domain.User;
import com.huayun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Autowired
    FavorDao favorDao;

    @Override
    public User login(String loginName, String phone, String userNo) {
        User _user = userDao.findUserByLoginNameAndPhoneAndUserNo(loginName,phone,userNo);
        return _user;
    }

    @Override
    public User login(String loginName, String userNo) {
        return userDao.findUserByLoginNameAndUserNo(loginName,userNo);
    }

    @Override
    public User queryUserByid(String userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public User add(User user) {
        return userDao.save(user);
    }

    @Override
    public Page<User> query(String name, String phone, int currentPage, int pageSize) {
        Page<User> _page =  userDao.findUsersByNameLikeAndPhoneLikeOrderByNameAsc(name,phone,new PageRequest(currentPage,pageSize));
        return _page;
    }



    @Override
    public boolean remove(String[] ids) {
        try {
            for(String id:ids){
                userDao.deleteById(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Favor favor(Favor favor) {
        return favorDao.save(favor);
    }

    @Override
    public boolean removeFavor(String userId, String articleId) {
        try {
            favorDao.deleteFavorByUserIdAndArticleId(userId,articleId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Favor queryFavorByUserIdAndArticleId(String userId, String articleId) {
        return favorDao.queryFirstByUserIdAndArticleId(userId,articleId);
    }

    @Override
    public List<Article_> queryFavorList(String userId) {
        return favorDao.queryFavorList(userId);
    }

//    @Override
//    public List<Pair> queryFavorAfterNewsList(String userId, String time) {
//        return favorDao.queryFavorRecentList(userId);
//    }



}
