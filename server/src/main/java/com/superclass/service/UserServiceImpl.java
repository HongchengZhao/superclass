package com.pomeloish.superclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pomeloish.superclass.model.User;
import com.pomeloish.superclass.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try{
            /*
            检查电话号码是否已被注册
             */

            userMapper.insert(user);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findById(Integer id) {
        try{
            return userMapper.findById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
