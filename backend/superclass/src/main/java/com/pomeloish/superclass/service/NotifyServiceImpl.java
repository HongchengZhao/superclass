package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pomeloish.superclass.dao.NotificationMapper;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public boolean addNotify(Notification notification){
        boolean flag = false;
        try{
            notificationMapper.insert(notification);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean updateNotify(Notification notification){
        boolean flag = false;
        try{
            notificationMapper.updateByPrimaryKey(notification);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteNotify(Integer id){
        boolean flag = false;
        try{
            notificationMapper.deleteByPrimaryKey(id);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Notification seeNotify(Integer notificationId){
        try{
            return notificationMapper.selectByPrimaryKey(notificationId);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
