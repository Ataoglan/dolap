package com.example.dolapcase.exception.code.impl;

import com.example.dolapcase.exception.code.ErrorCode;
import org.springframework.http.HttpStatus;

public enum DolapErrorCode implements ErrorCode {

    UNHANDLED_ERROR("error.9002",9002, HttpStatus.INTERNAL_SERVER_ERROR), // todo gereksizleri sil
    MISSING_PARAMETER("error.1001",1001, HttpStatus.BAD_REQUEST),
    UNAUTHORIZE_REQUEST("error.1002",1002, HttpStatus.UNAUTHORIZED),
    AUTHENTICATION("error.2000",2000, HttpStatus.UNAUTHORIZED),
    JWT_TOKEN_EXPIRED("error.2001",2001, HttpStatus.UNAUTHORIZED),
    INVALID_USERNAME_PASSWORD("error.2002",2002, HttpStatus.UNAUTHORIZED),
    REFRESH_TOKEN_EXPIRED("error.2003", 2003, HttpStatus.UNAUTHORIZED),
    BAD_REQUEST("error.2004",2004, HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND("error.3000", 3000, HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS("error.3001", 3001, HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_FOUND("error.4000", 4000, HttpStatus.BAD_REQUEST),
    CATEGORY_ALREADY_EXISTS("error.4001", 4002, HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND("error.5000", 5000, HttpStatus.BAD_REQUEST),
    PRODUCT_ALREADY_EXISTS("error.5000", 5000, HttpStatus.BAD_REQUEST);

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
