package com.example.dolapcase.exception.exceptions.categoryExceptions;


import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class CategoryAlreadyExistsException extends DolapException {
    public CategoryAlreadyExistsException() {
        super(DolapErrorCode.CATEGORY_ALREADY_EXISTS);
    }
}
