package com.mt.mp.articlesmanagement.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends AbstractApiException {

    public AlreadyExistsException(String message) {
        super(message);
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
