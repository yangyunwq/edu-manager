package com.yuxiu.edu.service;

import com.yuxiu.edu.exception.UserException;
import com.yuxiu.edu.mapper.UserMapper;
import com.yuxiu.edu.model.User;
import com.yuxiu.edu.utils.security.MD5Utils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author yangyun
 * @date 2019-08-05 18:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String login(User user, Model model, boolean remember, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), MD5Utils.toMD5(user.getPassword()), remember);
        try {
            subject.login(token);
            String code = (String) request.getSession().getAttribute("code");
            if (!code.equalsIgnoreCase(request.getParameter("code"))) {
                throw new UserException("验证码输入错误");
            }
        } catch (UnknownAccountException e) {
            throw new UserException("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            throw new UserException("用户名或密码错误");
        }
        request.getSession().setAttribute("user", user);
        request.getSession().setMaxInactiveInterval(30 * 60);
        if (remember) {
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("password", user.getPassword());
        } else {
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("password");
        }
        return "Modules/main/Default";
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.login(username);
        /* if (session.getAttribute("user") != null) {
            return "Modules/main/Default";
        }
       User user1 = userMapper.login(user);
        if (user1 == null) {
            throw new UserException("用户名或密码错！！！");
        }
        if (!code.equalsIgnoreCase((String) session.getAttribute("code"))) {
            throw new UserException("验证码输入错误！！！");
        }
        session.setAttribute("user", user1);
        session.setMaxInactiveInterval(30 * 60);
        if (remember) {
            session.setAttribute("username", user1.getUsername());
            session.setAttribute("password", user1.getPassword());
        } else {
            session.removeAttribute("username");
            session.removeAttribute("password");
        }
        return "Modules/main/Default";*/
    }
}
