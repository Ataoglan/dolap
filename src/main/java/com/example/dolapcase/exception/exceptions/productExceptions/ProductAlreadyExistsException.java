package com.example.dolapcase.exception.exceptions.productExceptions;

import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;

public class ProductAlreadyExistsException extends DolapException {
    public ProductAlreadyExistsException() {
        super(DolapErrorCode.PICTURE_NOT_FOUND);
    }
}
