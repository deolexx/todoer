package com.deo.todoer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

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


}
