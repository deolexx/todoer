package com.deo.todoer.exception;

import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoNotFoundException extends RuntimeException{
    //this exception will be thrown if todo wasnt found in a list
    public ToDoNotFoundException(String message) {
        super(message);
    }
}
