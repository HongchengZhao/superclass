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
    public boolean checkPhoneNumber(String phoneNumber){
       /* try{
           return userMapper.checkPhoneNumber(phoneNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return ;*/

       int num = userMapper.checkPhoneNumber(phoneNumber);
       if(num>0){
           return  false;
       }
       else return true;
    }

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try{
            /*
            检查电话号码是否已被注册
             */
            boolean test = checkPhoneNumber(user.getPhoneNumber());
            if (test) {
                userMapper.insert(user);
                flag = true;
            }
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

    @Override
    public User findByPhoneNumberAndPassword(String phoneNumber, String password) {
        User user = userMapper.findByPhoneNumber(phoneNumber);
        String psw=user.getPassword();
        if(psw!=null) System.out.println("wrong");

        if (user == null){
            return null;
        }
        if (psw != password){
            return null;
        }
        else return user;
    }

    @Override
    public boolean updateUser(User user){
        boolean flag = false;
        try{
            userMapper.updateUser(user);
            flag = true;

        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

}
