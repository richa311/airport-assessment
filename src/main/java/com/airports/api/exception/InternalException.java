package com.airports.api.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ResponseStatus(INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException {

    public InternalException(String message) {
        super(message);
    }
}
