package com.yuxiu.edu.service;

import com.yuxiu.edu.mapper.User1Mapper;
import com.yuxiu.edu.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangyun
 * @date 2019-08-08 09:24
 */
@Service
public class User1Service {
    @Autowired
    User1Mapper user1Mapper;

    public List<User1> getAll() {
        return user1Mapper.selectByExample(null);
    }
}
