package com.learn.SpringBootApplication.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity(name="TODO")
public class ToDo {

    public ToDo(){

    }

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=10, message="Enter atleast 10 characters")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return targetDate;
    }

    public void setDate(LocalDate date) {
        this.targetDate = date;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }


    private LocalDate targetDate;

    public ToDo(int id, String username, String description, LocalDate date, Boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = date;
        this.done = done;
    }

    private Boolean done;
}
