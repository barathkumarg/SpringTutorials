package com.learn.SpringBootApplication.jdbc;

import com.learn.SpringBootApplication.EmployeeBean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepositoryJpa {

    @PersistenceContext  //Annotation such as autowired in JPA
    private EntityManager entityManager;

    //insert Command
    public void insertQuery(Employee employee){
        entityManager.merge(employee);
    }

    // Search query in JPA
    public Employee findQuery(int id){
        return entityManager.find(Employee.class,id);
    }

    // Delete Query in JPA
    public void deleteQuery(int id){
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }



}
