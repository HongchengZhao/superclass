package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.RollCall;
import com.pomeloish.superclass.model.SigninRecord;

public interface SignInService {

    boolean addRollCall(RollCall rollCall);

    boolean addSignin(SigninRecord signinRecord);

    SigninRecord checkSignin(int signinId);
}
