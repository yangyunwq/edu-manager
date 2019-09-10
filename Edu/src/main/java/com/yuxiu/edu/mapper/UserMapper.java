package com.yuxiu.edu.mapper;

import com.yuxiu.edu.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangyun
 * @date 2019-08-05 18:14
 */
public interface UserMapper {
    User login(String username);
}
