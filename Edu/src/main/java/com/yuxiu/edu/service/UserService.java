package com.yuxiu.edu.service;

import com.yuxiu.edu.mapper.UserMapper;
import com.yuxiu.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangyun
 * @date 2019-08-05 18:19
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user);
    }
}
