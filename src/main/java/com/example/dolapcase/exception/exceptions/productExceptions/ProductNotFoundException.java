package com.example.dolapcase.exception.exceptions.productExceptions;

import com.example.dolapcase.exception.DolapException;
import com.example.dolapcase.exception.code.impl.DolapErrorCode;


public class ProductNotFoundException extends DolapException {
    public ProductNotFoundException() {
        super(DolapErrorCode.PRODUCT_NOT_FOUND);
    }
}
