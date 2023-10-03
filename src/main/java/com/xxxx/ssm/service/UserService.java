package com.xxxx.ssm.service;

import com.xxxx.ssm.dao.UserDao;
import com.xxxx.ssm.exception.BusinessException;
import com.xxxx.ssm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryUserByUserId(Integer userId){
        /*if(1==1){
            throw new BusinessException();
        }*/
        User user=userDao.queryUserByUserId(userId);
        return user;
    }
}
