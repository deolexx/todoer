package com.deo.todoer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class ExceptionsResponse {
    //this class will standardize exceptions responses
    public Date timestamp;
    public String message;
    public String details;
}
