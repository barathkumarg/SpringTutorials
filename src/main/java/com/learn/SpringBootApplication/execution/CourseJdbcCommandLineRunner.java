package com.learn.SpringBootApplication.execution;

import com.learn.SpringBootApplication.EmployeeBean.Employee;
import com.learn.SpringBootApplication.jdbc.EmployeeRepository;
import com.learn.SpringBootApplication.jdbc.EmployeeRepositoryJpa;
import com.learn.SpringBootApplication.jdbc.EmployeeRepositorySpirngDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
   // Will run when spring boot is launched and will execute the methods in commandlineRunner implements

    @Autowired
    EmployeeRepository employeeRepository;

    //JPA Configuration
    @Autowired
    EmployeeRepositoryJpa employeeRepositoryJpa;

    @Autowired
    EmployeeRepositorySpirngDataJpa springDataJpa;

    @Override
    public void run(String... args) throws Exception {
        //************************** Spring Boot jbdc - template ********************************
//        employeeRepository.insertQuery(new Employee(1,"Barathkumar","coimbatore"));
//        employeeRepository.insertQuery(new Employee(2,"Anoos","coimbatore"));
//
//        //Delete query in spring JDBC
//        employeeRepository.deleteById(1);
//
//        //fetch the employee object by select query
//        ;
//        System.out.println(employeeRepository.findById(2));

        //**************************Spring - JPA **********************************************
//        employeeRepositoryJpa.insertQuery(new Employee(1,"Barathkumar","coimbatore"));
//        employeeRepositoryJpa.insertQuery(new Employee(2,"Aswin","Erode"));
//
//        //delete
//        employeeRepositoryJpa.deleteQuery(2);
//
//        //search
//        System.out.println(employeeRepositoryJpa.findQuery(1));

        // *************************** Spring Data JPA **********************
        springDataJpa.save(new Employee(1,"Barath","coimbatore"));
        springDataJpa.save(new Employee(2,"Ashwin","Erode"));

        //delete
        springDataJpa.deleteById(2);

        //search query
        System.out.println(springDataJpa.findById(1));

        //Custo serach
        System.out.println(springDataJpa.findByname("Barath"));

    }
}
