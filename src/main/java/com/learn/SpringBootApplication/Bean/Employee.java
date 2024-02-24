package com.learn.SpringBootApplication.Bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

import java.util.List;

//@JsonFilter("locationFilter")   // filter name for dynamic filter
@Entity
public class Employee {

    //empty constructor
    protected Employee() {

    }

    //@JsonIgnore //-> Static filtering
    @Id
    @GeneratedValue
    private Integer id;  // ignore this attribute in the api

    @JsonIgnore
    @OneToMany(mappedBy = "employee_id")
    private List<Skill> skill;

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

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
