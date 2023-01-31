package com.east.springbootmall.service.impl;

import com.east.springbootmall.dao.UserDao;
import com.east.springbootmall.dto.UserLoginRequest;
import com.east.springbootmall.dto.UserRegisterRequest;
import com.east.springbootmall.model.User;
import com.east.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private  final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊的email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            log.warn("該email {} 已經被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用MD5 生成密碼的雜湊值
        String hsaheadPassowrd = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hsaheadPassowrd);

        //創建帳號
        return userDao.craeteUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        //檢查user 是否存在
        if(user == null){
            log.warn("該email {} 未被註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用MD5 生成密碼的雜湊值
        String hsaheadPassowrd = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());


        //比較密碼
        if(user.getPassword().equals(hsaheadPassowrd)){
            return user;
        }else {
            log.warn("該email {} 的密碼不正確",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }


    }
}
