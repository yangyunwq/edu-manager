package com.yuxiu.edu.controller;

import com.yuxiu.edu.mapper.User1Mapper;
import com.yuxiu.edu.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangyun
 * @date 2019-08-08 09:13
 */
@Controller
public class test {
    @Autowired
    User1Mapper user1Mapper;

    @RequestMapping("insert")
    public void insert() {
        for (int i = 100; i < 1000; i++) {
            User1 user1 = new User1(i, i, i, i, i, i, i, i, i);
            user1Mapper.insert(user1);
        }
    }
}
