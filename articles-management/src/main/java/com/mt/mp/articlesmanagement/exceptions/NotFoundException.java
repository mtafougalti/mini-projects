package com.mt.mp.articlesmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractApiException {

    public NotFoundException(String message) {
        super(message);
    }

    public HttpStatus getStatusCode(){
        return HttpStatus.NOT_FOUND;
    }
}
