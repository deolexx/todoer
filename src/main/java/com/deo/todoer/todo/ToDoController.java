package com.deo.todoer.todo;

import com.deo.todoer.exception.ToDoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ToDoController {
    ToDoDAOService toDoDAOService;
   @Autowired
    public ToDoController(ToDoDAOService toDoDAOService) {
        this.toDoDAOService = toDoDAOService;
    }
    //todo add methods for create change and delete todos

    @GetMapping("/todos")
    public List<ToDo> showAllToDos(){

        return toDoDAOService.getAllToDos();
    }

    @GetMapping("todos/{id}")
    public ToDo showToDoById(@PathVariable int id){

        ToDo toDoById = toDoDAOService.getToDoById(id);
        if(toDoById==null) {
            throw new ToDoNotFoundException("ToDo with id: "+id+" not found");
        }
        return toDoById;
    }


    @PostMapping("/todos")
    public ResponseEntity<ToDo> addNewToDO(@Valid @RequestBody ToDo toDo) {
        toDoDAOService.addNewTodo(toDo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(toDo.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("todos/{id}")
    public void removeToDoById(@PathVariable int id)   {
        ToDo toDo = toDoDAOService.deleteTodoById(id);
        if(toDo==null){throw new ToDoNotFoundException("ToDo with id: "+id+" not found");}
    }

}
