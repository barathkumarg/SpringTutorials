package com.learn.SpringBootApplication.Controller;


import com.learn.SpringBootApplication.Bean.Employee;
import com.learn.SpringBootApplication.ErrorHandlings.CustomResourceNotFoundException;
import com.learn.SpringBootApplication.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Restcontroller {

    EmployeeService service;
    public Restcontroller(EmployeeService service){
        this.service = service;
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
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        service.saveEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
