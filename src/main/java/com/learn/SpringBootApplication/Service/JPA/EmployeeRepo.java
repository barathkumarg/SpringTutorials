package com.learn.SpringBootApplication.Service.JPA;

import com.learn.SpringBootApplication.Bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
