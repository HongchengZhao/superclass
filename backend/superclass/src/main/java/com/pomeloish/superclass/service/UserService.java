package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.User;

public interface UserService {

    boolean addUser(User user);

    User findById(Integer id);
}
