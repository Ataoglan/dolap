package com.example.dolapcase.exception.code.impl;

import com.example.dolapcase.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public enum DolapErrorCode implements ErrorCode {

    MISSING_PARAMETER("error.1000",1000, HttpStatus.NOT_ACCEPTABLE),
    UNHANDLED_ERROR("error.1001",1001, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND("error.3000", 3000, HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS("error.3001", 3001, HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_FOUND("error.4000", 4000, HttpStatus.BAD_REQUEST),
    CATEGORY_ALREADY_EXISTS("error.4001", 4001, HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND("error.5000", 5000, HttpStatus.BAD_REQUEST),
    PRODUCT_ALREADY_EXISTS("error.5001", 5001, HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;
    private final String code;
    private final int codeInt;

    DolapErrorCode(String code, int codeInt, HttpStatus httpStatus){
        this.code = code;
        this.httpStatus = httpStatus;
        this.codeInt = codeInt;
    }

    @Override
    public String code(){return code;}

    @Override
    public HttpStatus httpStatus(){return httpStatus;}

    @Override
    public int codeInt(){return codeInt;}
}
