package com.yuxiu.edu.service;

import com.yuxiu.edu.exception.UserException;
import com.yuxiu.edu.mapper.UserMapper;
import com.yuxiu.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * @author yangyun
 * @date 2019-08-05 18:19
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public String login(User user, HttpSession session, boolean remember, String code) throws UserException {
        if (session.getAttribute("user") != null) {
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
        return "Modules/main/Default";
    }
}
