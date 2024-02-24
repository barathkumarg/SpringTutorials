package com.learn.SpringBootApplication.Controller;


import com.learn.SpringBootApplication.Bean.Employee;
import com.learn.SpringBootApplication.ErrorHandlings.CustomResourceNotFoundException;
import com.learn.SpringBootApplication.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class Restcontroller {

    //constructor injection for message source
    private MessageSource message;

    //Employee service constructor injection
    EmployeeService service;
    public Restcontroller(EmployeeService service,MessageSource message){

        this.service = service;
        this.message = message;
    }

    //controller logic
    @GetMapping("/employee")
    public List<Employee> getallEMployee(){
        return service.getallEmployee();
    }

    //HATEOS example
    @GetMapping("/employee/{id}")
    public EntityModel<Employee> getemployee(@PathVariable int id){
        Employee employee =  service.getEmployee(id);

        if (employee == null){
            throw new CustomResourceNotFoundException("Id not found : "+ id);
        }
        //Adding the hateos info for the employee/id url
        EntityModel<Employee> entitymodel = EntityModel.of(employee);
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getallEMployee());
        entitymodel.add(link.withRel("all-users"));

        return entitymodel;
    }

    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
    }


    //post url
    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee){
        service.saveEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //controller for internationalization example
    @GetMapping("/hello")
    public String hello(){
        Locale locale = LocaleContextHolder.getLocale();
        return message.getMessage("good.morning.message", null, "Default Message", locale );
    }

}
