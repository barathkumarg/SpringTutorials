package com.learn.SpringBootApplication.jdbc;

import com.learn.SpringBootApplication.EmployeeBean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositorySpirngDataJpa extends JpaRepository<Employee,Integer> {

    //Custom find query
    List<Employee> findByname(String name);

}
