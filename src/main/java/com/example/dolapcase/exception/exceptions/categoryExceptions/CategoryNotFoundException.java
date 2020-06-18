package com.example.dolapcase.exception.exceptions.categoryExceptions;

import com.ataoglan.ataoglanblog.exception.BlogException;
import com.ataoglan.ataoglanblog.exception.code.impl.BlogErrorCode;

public class CategoryNotFoundException extends BlogException {
    public CategoryNotFoundException() {
        super(BlogErrorCode.CATEGORY_NOT_FOUND);
    }
}
