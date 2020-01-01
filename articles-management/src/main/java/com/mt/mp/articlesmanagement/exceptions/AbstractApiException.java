package com.mt.mp.articlesmanagement.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractApiException extends RuntimeException{
    public AbstractApiException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
