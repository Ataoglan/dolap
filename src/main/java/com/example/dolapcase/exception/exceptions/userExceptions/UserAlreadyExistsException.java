package com.example.dolapcase.exception.exceptions.userExceptions;

import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class UserAlreadyExistsException extends DolapException {
    public UserAlreadyExistsException(){super(DolapErrorCode.USER_ALREADY_EXISTS);}
}
