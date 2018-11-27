package com.huayun.user.controller;

import com.huayun.common.AbstractController;
import com.huayun.common.ResultObject;
import com.huayun.user.domain.Favor;
import com.huayun.user.domain.User;
import com.huayun.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @ResponseBody
    @RequestMapping(value = "/login/account",method = RequestMethod.POST, produces = "application/json")
    public Map reactlogin(@RequestBody Map body ){

        String  password = (String) body.get("password");
        String userName = (String )body.get("userName");

        User user = userService.login(userName,password);
        Map map = new HashMap();
        map.put("status","ok");
        map.put("user",user);
        map.put("type","");
        map.put("currentAuthority","admin");

        return map;
//        return this.success(userService.login((String)body.get("userName"),(String)body.get("password")));
    }
    @ResponseBody
    @RequestMapping(value = "/user/currentUser",method = RequestMethod.GET)
    public ResultObject currentUser(@RequestParam("userId") String userId){
        return this.success(userService.queryUserByid(userId));
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

    @ResponseBody
    @RequestMapping(value = "/user/addFavor", method = RequestMethod.POST)
    public ResultObject addFavor(Favor body) {
        body.setModifyDatetime(Long.toString(new Date().getTime()));
        return this.success(userService.favor(body));
    }

    @ResponseBody
    @RequestMapping(value = "/user/removeFavor", method = RequestMethod.GET)
    public ResultObject removeFavor(
                                    @RequestParam("userId") String userId,
                                    @RequestParam("articleId") String articleId
                                    ) {
        return this.success(userService.removeFavor(userId,articleId));
    }

    @ResponseBody
    @RequestMapping(value = "/user/queryFavorList", method = RequestMethod.GET)
    public ResultObject queryFavorList(@RequestParam("userId") String userId){
        return this.success(userService.queryFavorList(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/user/queryFavorByUserIdAndArticleId", method = RequestMethod.GET)
    public ResultObject queryFavorByUserIdAndArticleId(@RequestParam("userId") String userId,
                                                 @RequestParam("articleId") String articleId){
        return this.success(userService.queryFavorByUserIdAndArticleId(userId,articleId));
    }
}
