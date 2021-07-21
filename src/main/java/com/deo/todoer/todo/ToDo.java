package com.deo.todoer.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class ToDo {
    @Null(message = "The id will be set automatically")
    private Integer id;
    @Size(min = 1)
    private String name;
    @Future(message = "You cant choose the date in past")
    private Date date;
}
