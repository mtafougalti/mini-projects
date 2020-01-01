package com.mt.mp.articlesmanagement.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbstractApiException.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(AbstractApiException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getStatusCode().toString(), request.getDescription(false));
        errorDetails.addErrorMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetails, exception.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.toString(), request.getDescription(false));
        errorDetails.addErrorMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(status.toString(), request.getDescription(false));
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorDetails.addErrorMessage(error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorDetails, status);
    }
}
