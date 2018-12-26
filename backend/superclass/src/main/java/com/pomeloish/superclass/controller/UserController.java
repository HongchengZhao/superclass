package com.pomeloish.superclass.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

import com.pomeloish.superclass.model.User;
import com.pomeloish.superclass.service.UserService;

@RestController
@RequestMapping(value="api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }
}
