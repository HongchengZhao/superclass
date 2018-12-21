package com.example.superclass.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.superclass.dao.UserDao;
import com.example.superclass.entity.UserEntity;

@Controller
@RequestMapping("/user/*")
public class IndexController {
    @Autowired
    private UserDao userdao;

    private User user=new User();

    @RequestMapping("/index")
    public String index(HttpSession httpSession) {
        httpSession.getAttribute("userLogin");
        return "index";
    }


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        String str="";
        String username=user.getUsername();
        if(username!=null) {
            str="index";
        }else {
            str="login";
        }
        return str;
    }


    @RequestMapping("/uregister")
    public String register(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        String realname=request.getParameter("realname");
        String str="";
        if(password.equals(password2)) {
            user=userdao.findByName(username);
            if(user==null) {
                User user=new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setRealname(realname);
                userdao.save(user);
                str="login";
            }else {
                str="register";
            }
        }else {
            str="register";
        }
        return str;
    }


    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request,HttpSession session) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user=userdao.findBynameAndPassword(username, password);
        String str="";
        if(user!=null) {
            session.setAttribute("userLogin", user);
            str="index";
        }else {
            str="login";
        }
        return str;
    }
}