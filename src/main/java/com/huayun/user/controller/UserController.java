package com.huayun.user.controller;

import com.huayun.article.domain.Article;
import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import com.huayun.user.domain.User;
import com.huayun.user.service.UserService;
import com.huayun.utils.ImageUtils;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("api")
public class UserController  extends AbstractController{
    @Autowired
    UserService userService;

    /**
     * 用户身份认证；
     * @param loginName，登录名
     * @param phone，手机号
     * @param userNo，工号
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultObject login(@RequestParam("loginName") String loginName,@RequestParam("phone") String phone,@RequestParam("userNo") String userNo){
        return this.success(userService.login(loginName,phone,userNo));
    }

    /**
     * 管理控制台用户登录；
     * @param loginName
     * @param userNo
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/login/account",method = RequestMethod.POST, produces = "application/json")
//    public ResultObject reactlogin(@RequestBody String userName,
//                              @RequestBody String password,
//                              @RequestBody String type){
//
//        return this.success(userService.login(userName,password));
//    }

    @ResponseBody
    @RequestMapping(value = "/login/account",method = RequestMethod.POST, produces = "application/json")
    public Map reactlogin(@RequestBody Map body ){

//        return null;

        Map map = new HashMap();
        map.put("status","ok");
        map.put("type","");
        map.put("currentAuthority","admin");

        return map;
//        return this.success(userService.login((String)body.get("userName"),(String)body.get("password")));
    }
//    {userName: "admin", password: "ant.design", type: "account"

//    /**
//     * 管理控制台用户登录；
//     * @param loginName
//     * @param userNo
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/login/account",method = RequestMethod.GET)
//    public ResultObject login(@RequestParam("loginName") String loginName,@RequestParam("userNo") String userNo){
//        return this.success(userService.login(loginName,userNo));
//    }
    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResultObject add(User user) {

        return this.success(userService.add(user));
    }

    @ResponseBody
    @RequestMapping(value = "/user/query", method = RequestMethod.GET)
    public ResultObject query(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize){


        return this.pageDecorator(userService.query("%" +name+"%","%" +phone+"%",currentPage,pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/user/remove", method = RequestMethod.POST)
    public ResultObject remove(@RequestBody String[] ids){
        return this.success(userService.remove(ids));
    }

}
