package com.learn.SpringBootApplication.service;

import com.learn.SpringBootApplication.Bean.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJPARepository extends JpaRepository<ToDo, Integer> {

    public List<ToDo> findByUsername(String username);



}
