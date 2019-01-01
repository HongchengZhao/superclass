package com.pomeloish.superclass.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.pomeloish.superclass.model.SigninRecord;
import com.pomeloish.superclass.model.RollCall;
import com.pomeloish.superclass.service.SignInService;


@RestController
@RequestMapping(value="api/signinrecords")
public class SigninController {
    @Autowired
    private SignInService signInService;

    @PostMapping("/addRollCall")
    public boolean addRollcall(@RequestBody RollCall rollCall){
        return signInService.addRollCall(rollCall);
    }
    @PostMapping("/addSignin")
    public boolean addSignin(@RequestBody SigninRecord signinRecord){
        return signInService.addSignin(signinRecord);
    }
    @GetMapping(value="/{signinId}")
    public SigninRecord checkSignin(@PathVariable ("signinId") Integer signinID){
        return signInService.checkSignin(signinID);
    }
}
