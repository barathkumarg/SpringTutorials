package com.learn.SpringBootApplication.controller;

import com.learn.SpringBootApplication.Configuration.ServiceConfig;
import com.learn.SpringBootApplication.DAO.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ControllerClass {

    @RequestMapping("/getcourses")
    public List<Course> getcourses(){

        return Arrays.asList( new Course(1,"python",2000),
                new Course(2,"Java",1000),
                new Course(3,"c++",1000),
                new Course(4,"scala",1000)


                );


    }

    @Autowired
    ServiceConfig serviceconfig;
    @RequestMapping("/getconfig")
    public ServiceConfig getconfig(){
         return serviceconfig;
    }
}
