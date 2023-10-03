package com.xxxx.ssm.dao;

import com.xxxx.ssm.po.User;


public interface UserDao {
    User queryUserByUserId(Integer userId);
}
