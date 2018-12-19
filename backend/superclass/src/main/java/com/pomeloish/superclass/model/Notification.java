package com.pomeloish.superclass.model;

import java.io.Serializable;

public class Notification implements Serializable {
    private Integer notificationId;

    private Integer classId;

    private String notification;

    private static final long serialVersionUID = 1L;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification == null ? null : notification.trim();
    }
}