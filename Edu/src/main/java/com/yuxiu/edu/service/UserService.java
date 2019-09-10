package com.yuxiu.edu.service;

import com.yuxiu.edu.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface UserService {
   String login(User user, Model model, boolean remember, HttpServletRequest request);
   User findUserByUsername(String username);
}
