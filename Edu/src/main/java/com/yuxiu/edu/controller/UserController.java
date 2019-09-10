package com.yuxiu.edu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xml.internal.serializer.Method;
import com.yuxiu.edu.exception.UserException;
import com.yuxiu.edu.model.User;
import com.yuxiu.edu.model.User1;
import com.yuxiu.edu.service.User1Service;
import com.yuxiu.edu.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.javassist.compiler.MemberResolver;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String login(User user, Model model, boolean remember, HttpServletRequest request) {
        return userService.login(user, model, remember, request);
    }
    @RequestMapping("main1")
    public String main() {
        return "Modules/main/Default";
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

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String userAdd() {
        return INFO_PAGE;
    }
}
