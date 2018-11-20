package com.huayun.menu.controller;

import com.huayun.menu.domain.Menu;
import com.huayun.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
public class MenuController{
    @Autowired
    MenuService menuService;

    @ResponseBody
    @RequestMapping(value="/menus" , method = RequestMethod.GET)
    public List<Menu> getMenuList(){
//        {
//            "path": "/news",
//                "name": "炼化新闻",
//                "locale": "menu.forums",
//                "icon": 'usergroup-add',
//                "children":[
//            // {
//            //     path: '/news/smallcatalog',
//            //     // name: 'smallcatalog',
//            //     name: '小类',
//            //     component: './News/SmallCatalog',
//            //     // "locale": "menu.forums.subject"
//            // },
//            {
//                path: '/news/article/1',
//                        name: '公司要闻',
//                    // name: 'news',
//                    component: './News/News',
//                // "locale": "menu.forums.subject"
//            },
//            {
//                path: '/news/article/2',
//                        name: '外媒看炼化',
//                    component: './News/News',
//                // "locale": "menu.forums.subject"
//            }
//            ]
//        }
        return menuService.getMenuList();
    }
}
