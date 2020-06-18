package com.example.dolapcase.exception.code;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String code();
    HttpStatus httpStatus();
    int codeInt();
}
