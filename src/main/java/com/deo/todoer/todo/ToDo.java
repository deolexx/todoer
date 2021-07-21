package com.deo.todoer.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class ToDo {
    private Integer id;
    @Size(min = 1)
    private String name;
    @Future
    private Date date;
}
