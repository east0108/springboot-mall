package com.east.springbootmall.service.impl;

import com.east.springbootmall.dao.UserDao;
import com.east.springbootmall.dto.UserRegisterRequest;
import com.east.springbootmall.model.User;
import com.east.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.craeteUser(userRegisterRequest);
    }


}
