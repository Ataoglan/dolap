package com.example.dolapcase.exception;


import com.example.dolapcase.exception.code.ErrorCode;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class DolapException extends RuntimeException{
    private final transient ErrorCode errorCode;
    private String message;
    private String[] params;
    private Throwable throwable;

    public DolapException(String message) {
        this.message = message;
        this.errorCode = DolapErrorCode.UNHANDLED_ERROR;
    }

    public DolapException(ErrorCode errorCode){this.errorCode = errorCode;}

    public DolapException(ErrorCode errorCode, Throwable throwable){
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public DolapException(String logMessage, Throwable t) {
        this.message = logMessage;
        this.throwable = t;
        this.errorCode = DolapErrorCode.UNHANDLED_ERROR;
    }

    public DolapException(ErrorCode errorCode, Throwable t, String... params) {
        this.errorCode = errorCode;
        this.throwable = t;
        this.params = params;
    }

    public DolapException(String message, ErrorCode errorCode, Throwable t, String... params) {
        this.errorCode = errorCode;
        this.throwable = t;
        if (params != null && params.length > 0) {
            this.message = String.format(message, (Object[]) params);
        }
    }

    public DolapException(String message, ErrorCode errorCode, Throwable t) {
        this.errorCode = errorCode;
        this.throwable = t;
        if (params != null && params.length > 0) {
            this.message = String.format(message, (Object[]) params);
        }
    }

    public ErrorCode getErrorCode() {
        return errorCode;
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
