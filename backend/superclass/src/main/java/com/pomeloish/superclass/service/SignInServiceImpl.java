package com.pomeloish.superclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pomeloish.superclass.model.RollCall;
import com.pomeloish.superclass.model.SigninRecord;
import com.pomeloish.superclass.dao.RollCallMapper;
import com.pomeloish.superclass.dao.SigninRecordMapper;

@Service
public class SignInServiceImpl implements SignInService{
    @Autowired
    private RollCallMapper rollCallMapper;
    @Autowired
    private SigninRecordMapper signinRecordMapper;
    @Override
    public boolean addRollCall(RollCall rollCall){
        boolean flag = false;
        try{
            rollCallMapper.insert(rollCall);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean addSignin(SigninRecord signinRecord){
        boolean flag = false;
        try{
            signinRecordMapper.insert(signinRecord);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public SigninRecord checkSignin(int signinID){
        try{
            return signinRecordMapper.checkSignin(signinID);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

