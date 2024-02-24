package com.learn.SpringBootApplication.Controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learn.SpringBootApplication.Bean.Employee;
import com.learn.SpringBootApplication.Bean.Skill;
import com.learn.SpringBootApplication.ErrorHandlings.CustomResourceNotFoundException;
import com.learn.SpringBootApplication.Service.EmployeeService;
import com.learn.SpringBootApplication.Service.JPA.EmployeeRepo;
import com.learn.SpringBootApplication.Service.JPA.SkillRepo;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RestJPAcontroller {


    //Employee service constructor injection
    SkillRepo skillrepository;
    EmployeeRepo repository;

    public RestJPAcontroller(SkillRepo skillrepository,EmployeeRepo repository){

        this.skillrepository = skillrepository;
        this.repository = repository;

    }

    //controller logic
    @GetMapping("/jpa/employee/filter")
    public MappingJacksonValue getallEMployeefilter(){

        List<Employee> emp_list =  repository.findAll();

        //Example for Dynamic filtering
        MappingJacksonValue jacksonValue = new MappingJacksonValue(emp_list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("location","id");  //filtering out the location.
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter",filter);

        jacksonValue.setFilters(filters);
        return jacksonValue;
    }

    @GetMapping("/jpa/employee")
    public List<Employee> getallEMployee(){

        return repository.findAll();

    }



    //HATEOS example
    @GetMapping("/jpa/employee/{id}")
    public EntityModel<Employee> getemployee(@PathVariable int id){
        Optional<Employee> employee =  repository.findById(id);

        if (employee.isEmpty()){
            throw new CustomResourceNotFoundException("Id not found : "+ id);
        }
        //Adding the hateos info for the employee/id url
        EntityModel<Employee> entitymodel = EntityModel.of(employee.get());
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getallEMployee());
        entitymodel.add(link.withRel("all-users"));

        return entitymodel;
    }

    @GetMapping("/jpa/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        repository.deleteById(id);
    }


    //post url
    @PostMapping("/jpa/employee")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee){
        repository.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/employee/{id}/skill")
    public List<Skill> getskillbyEmployee(@PathVariable Integer id){
        Optional<Employee> employee = repository.findById(id);
        if (employee.isEmpty()){
            throw new CustomResourceNotFoundException("id: "+id);
        }
        return (List<Skill>) employee.get().getSkill();

    }

}
