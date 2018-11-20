package com.huayun.user.controller;

import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import com.huayun.user.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

}
