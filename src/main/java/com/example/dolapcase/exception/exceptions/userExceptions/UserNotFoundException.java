package com.example.dolapcase.exception.exceptions.userExceptions;

import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class UserNotFoundException extends DolapException {
    public UserNotFoundException(){super(DolapErrorCode.USER_NOT_FOUND);}
}
