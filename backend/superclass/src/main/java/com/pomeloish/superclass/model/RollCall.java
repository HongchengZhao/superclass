package com.pomeloish.superclass.model;

import java.io.Serializable;
import java.util.Date;

public class RollCall implements Serializable {
    private Integer signinId;

    private Integer classId;

    private Date date;

    private Double longtitude;

    private Double latitude;

    private static final long serialVersionUID = 1L;

    public Integer getSigninId() {
        return signinId;
    }

    public void setSigninId(Integer signinId) {
        this.signinId = signinId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}