package com.pomeloish.superclass.model;

import java.io.Serializable;

public class SigninRecord implements Serializable {
    private Integer userId;

    private Integer signinId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSigninId() {
        return signinId;
    }

    public void setSigninId(Integer signinId) {
        this.signinId = signinId;
    }
}