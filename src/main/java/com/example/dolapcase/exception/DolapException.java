package com.example.dolapcase.exception;


import com.example.dolapcase.exception.code.ErrorCode;

public class DolapException extends RuntimeException{
    private final transient ErrorCode errorCode;
    private String message;
    private String[] params;
    private Throwable throwable;

    public DolapException(ErrorCode errorCode){this.errorCode = errorCode;}

    public DolapException(ErrorCode errorCode, Throwable t, String... params) {
        this.errorCode = errorCode;
        this.throwable = t;
        this.params = params;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String[] getParams() {
        return params;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
