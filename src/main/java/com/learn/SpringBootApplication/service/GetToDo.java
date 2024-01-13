package com.learn.SpringBootApplication.service;

import com.learn.SpringBootApplication.Bean.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.function.Predicate;

@Service
public class GetToDo {
    //Create the predefined to-do list to display

    static private ArrayList<ToDo> todolist = new ArrayList<>();
    static int count = 0;

    static {
        todolist.add(new ToDo(++count,"arun","To learn scala",LocalDate.now(),true));
        todolist.add(new ToDo(++count,"barath","To learn Python", LocalDate.now().plusYears(1),true));
        todolist.add(new ToDo(++count,"barath","To learn java",LocalDate.now(),true));
    }

    public ArrayList<ToDo> getlist(){
        return todolist;
    }

    public void addToDo(String username,String description, LocalDate date,Boolean isdone){
        todolist.add(new ToDo(++count,username,description,date,isdone));
    }

    public void deleteToDo(int id){

        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        todolist.removeIf(predicate);
    }

    public ToDo getIdTodo(int id){
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        ToDo todo = todolist.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void UpdateTodo(int id, ToDo updateTodo){
        ToDo oldTodo = getIdTodo(id);
        oldTodo.setDescription((String) updateTodo.getDescription());
        oldTodo.setDate((LocalDate) updateTodo.getDate());
    }



}
