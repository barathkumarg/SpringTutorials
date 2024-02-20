package com.learn.SpringBootApplication.Controller;


import com.learn.SpringBootApplication.Bean.Employee;
import com.learn.SpringBootApplication.ErrorHandlings.CustomResourceNotFoundException;
import com.learn.SpringBootApplication.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

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

    @GetMapping("/employee/{id}")
    public Employee getemployee(@PathVariable int id){
        Employee employee =  service.getEmployee(id);

        if (employee == null){
            throw new CustomResourceNotFoundException("Id not found : "+ id);
        }
        return employee;
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
