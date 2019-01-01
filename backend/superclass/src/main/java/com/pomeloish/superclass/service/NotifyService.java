package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.Notification;

public interface NotifyService {
    boolean addNotify(Notification notification);

    boolean updateNotify(Notification notification);

    boolean deleteNotify(Integer id);

    Notification seeNotify(Integer notificationId);
}
