package com.huayun.menu.service.impl;

import com.huayun.menu.dao.MenuDao;
import com.huayun.menu.domain.Menu;
import com.huayun.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() {
        return menuDao.findAllByOrderBySeqAsc();
    }

}
