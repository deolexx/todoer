package com.deo.todoer.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Component
public class ToDoDAOService {
    //fixme: temporary hardcode the list with todos
    // into class
    private static List<ToDo> toDoList = new ArrayList<>();
    private static int todoCounter =3;
    //add s few todos for better applicatoin testing
    static {
        toDoList.add(new ToDo(1,"do some pushups",new Date()));
        toDoList.add(new ToDo(2,"learn Java",new Date()));
        toDoList.add(new ToDo(3,"practice programming",new Date()));
    }

    public List<ToDo> getAllToDos(){
        return toDoList;
    }

    public ToDo getToDoById(int id){
        for(ToDo toDo : toDoList){
            if(toDo.getId()==id)return toDo;
        }
        return null;
    }
    public ToDo addNewTodo(ToDo toDo){
        if(toDo.getId()==null){
            toDo.setId(++todoCounter);
        }
        toDoList.add(toDo);
        return toDo;
    }
    public ToDo deleteTodoById(int id){
        Iterator<ToDo> iterator = toDoList.iterator();
        while (iterator.hasNext()){
            ToDo toDo = iterator.next();
            if(toDo.getId() == id) iterator.remove();
            return toDo;
        }
        return null;
    }




}
