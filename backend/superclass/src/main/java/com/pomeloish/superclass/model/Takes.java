package com.pomeloish.superclass.model;

import java.io.Serializable;

public class Takes implements Serializable {
    private Integer userId;

    private Integer classId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}