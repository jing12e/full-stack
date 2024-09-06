package com.jing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationEXception extends RuntimeException {
    public RequestValidationEXception(String message) {
        super(message);
    }
}
