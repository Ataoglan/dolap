package com.example.dolapcase.exception.exceptions.categoryExceptions;

import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class CategoryNotFoundException extends DolapException {
    public CategoryNotFoundException() {
        super(DolapErrorCode.CATEGORY_NOT_FOUND);
    }
}
