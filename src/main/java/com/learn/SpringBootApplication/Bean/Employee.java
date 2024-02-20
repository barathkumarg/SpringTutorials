package com.learn.SpringBootApplication.Bean;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;


public class Employee {

    private Integer id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Size(min = 2,message = "Atleast 2 characters required")
    private String name;

    public Employee(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Size(min = 4,message = "Atleast 2 characters required")
    private String location;

}
