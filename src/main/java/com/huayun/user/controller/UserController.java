package com.huayun.user.controller;

import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import com.huayun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
