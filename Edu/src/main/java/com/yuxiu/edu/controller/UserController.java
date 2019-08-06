package com.yuxiu.edu.controller;

import com.yuxiu.edu.model.User;
import com.yuxiu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangyun
 * @date 2019-08-05 17:44
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login() {
        return "Default";
    }

    @RequestMapping("userManager")
    public String userManager() {
        return "Modules/User/UserManage";
    }

    @RequestMapping("userInfo")
    public String userInfo() {
        return "Modules/User/UserInfo";
    }

    @RequestMapping("userEdit")
    public String userEdit() {
        return "Modules/User/UserEdit";
    }

}
