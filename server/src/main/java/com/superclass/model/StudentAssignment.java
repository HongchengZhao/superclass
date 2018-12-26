package com.pomeloish.superclass.model;

import java.io.Serializable;

public class StudentAssignment implements Serializable {
    private Integer uploadedId;

    private Integer assignmentId;

    private String filePath;

    private Integer grade;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getUploadedId() {
        return uploadedId;
    }

    public void setUploadedId(Integer uploadedId) {
        this.uploadedId = uploadedId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}