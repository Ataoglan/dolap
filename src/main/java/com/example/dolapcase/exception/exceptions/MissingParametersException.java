package com.example.dolapcase.exception.exceptions;


import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class MissingParametersException extends DolapException {

    public MissingParametersException(String ... params){super(DolapErrorCode.MISSING_PARAMETER, null, params);}
}
