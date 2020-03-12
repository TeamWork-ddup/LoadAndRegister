package com.liyo.demon.service;

import com.liyo.demon.dao.UserDao;
import com.liyo.demon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    // 注册用户
    public boolean insertUser(User user){
        try{
            return userDao.insert(user) == 1;
        } catch (Exception e){
            return false;
        }

    }

    // 登录
    public boolean login(User user){
        User u = userDao.selectByPrimaryKey(user.getId());
        if(u == null){
            return false;
        }
        if(user.getPassword().equals(u.getPassword())){
            return true;
        } else {
            return false;
        }
    }

}
