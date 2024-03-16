package com.learn.SpringBootApplication.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Skill {

    protected Skill(){

    }
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee(Employee employee) {
        this.employee_id = employee;
    }

    public Skill(Integer id, String message, Employee employee) {
        this.id = id;
        this.message = message;
        this.employee_id = employee;
    }

    @Size(min=2)
    private String message;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee_id;
}
