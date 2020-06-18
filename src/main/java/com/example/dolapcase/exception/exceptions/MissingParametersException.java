package com.example.dolapcase.exception.exceptions;

import com.ataoglan.ataoglanblog.exception.BlogException;
import com.ataoglan.ataoglanblog.exception.code.impl.BlogErrorCode;

public class MissingParametersException extends BlogException {

    public MissingParametersException(String ... params){super(BlogErrorCode.MISSING_PARAMETER, null, params);}
}
