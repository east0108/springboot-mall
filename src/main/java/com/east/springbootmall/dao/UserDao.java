package com.east.springbootmall.dao;

import com.east.springbootmall.dto.UserRegisterRequest;
import com.east.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer craeteUser(UserRegisterRequest userRegisterRequest);
}
