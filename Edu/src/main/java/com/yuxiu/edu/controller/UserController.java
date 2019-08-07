package com.yuxiu.edu.controller;

import com.yuxiu.edu.exception.UserException;
import com.yuxiu.edu.model.User;
import com.yuxiu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yangyun
 * @date 2019-08-05 17:44
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {
    @Autowired
    UserService userService;

    @RequestMapping("main")
    public String login(User user, HttpSession session, boolean remember, String code) {
        return userService.login(user, session, remember, code);
    }

    @RequestMapping("userManager")
    public String userManager() {
        return MANAGE_PAGE;
    }

    @RequestMapping("userInfo")
    public String userInfo() {
        return INFO_PAGE;
    }

    @RequestMapping("userEdit")
    public String userEdit() {
        return EDIT_PAGE;
    }

}
