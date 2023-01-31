package com.east.springbootmall.service;

import com.east.springbootmall.dto.UserRegisterRequest;
import com.east.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
