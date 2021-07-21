package com.deo.todoer.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<Object>(exceptionsResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ToDoNotFoundException.class)
    public final ResponseEntity<Object> handleToDoNotFoundException(Exception ex, WebRequest request) {
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<Object>(exceptionsResponse,HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionsResponse exceptionsResponse =  new ExceptionsResponse(new Date(),"Validation failed",ex.getBindingResult().toString());

        return new ResponseEntity<Object>(exceptionsResponse, HttpStatus.BAD_REQUEST);
    }


}
