package com.learn.SpringBootApplication.Controller;

import com.learn.SpringBootApplication.Bean.ToDo;
import com.learn.SpringBootApplication.service.GetToDo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes("name")
@Controller
public class TodoListController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public GetToDo getToDo;

    // ********************     View To do list **********************************8
    @RequestMapping(value = "todo-list", method = RequestMethod.GET)
    public String getTodoList(ModelMap map){
        List<ToDo> todo_list = getToDo.getlist();
        map.put("todos",todo_list);
        return "todo-list";
    }

    // ***************************  Add the To do List  ***********************************
    @RequestMapping(value="/add-todo-list",method=RequestMethod.GET)
    public String addTodoGet(ModelMap map){

        ToDo todo = new ToDo(0, (String) (map.get("name")), "", LocalDate.now().plusYears(1), false);
        map.put("todo", todo);

        return "add-todo-list";
    }

    @RequestMapping(value = "/add-todo-list",method = RequestMethod.POST)
    public String addTodoPost(ModelMap map, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result){
        // error logic
        if (result.hasErrors()){
            //additional line
            logger.info("At error on description");
            return "add-todo-list";
        }

        //logic to add the to do via command bean
        getToDo.addToDo((String) (map.get("name")),todo.getDescription(),todo.getDate(),true);
        return "redirect:todo-list";
    }

    //*********************************  Delete To do List   ************************

    @RequestMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam int id){
        getToDo.deleteToDo(id);
        return "redirect:todo-list";

    }

    //********************************  Update the to do List *****************************
    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id,ModelMap model){
        ToDo todo = getToDo.getIdTodo(id);
        model.addAttribute("todo",todo);
        return "add-todo-list";
    }

    @RequestMapping(value="/update-todo",method = RequestMethod.POST)
    public String updateTodoPost(@Valid @ModelAttribute("todo") ToDo todo,BindingResult result){
        // error logic
        if (result.hasErrors()){
            //additional line
            logger.info("At error on description");
            return "add-todo-list";
        }
        getToDo.UpdateTodo((int)todo.getId(),todo);

        return "redirect:todo-list";
    }

}
