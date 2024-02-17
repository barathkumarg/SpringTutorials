package com.learn.SpringBootApplication.Service;

import com.learn.SpringBootApplication.Bean.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class EmployeeService {

    static int count = 0;
    static ArrayList<Employee> employeeList= new ArrayList<>();
    static{
        employeeList.add(new Employee(++count,"Barath","coimbatore"));
        employeeList.add(new Employee(++count,"arun","erode"));
    }

    // get all the employee list
    public List<Employee> getallEmployee(){
        return employeeList;
    }

    //get the employee by id
    public Employee getEmployee(int id){
        Predicate<? super Employee> predicate = employee -> employee.getId().equals(id);
        return employeeList.stream().filter(predicate).findFirst().orElse(null);
    }

    //save the employee
    public Employee saveEmployee(Employee employee){
        employee.setId(++count);
        employeeList.add(employee);
        return employee;
    }

    //Delete the user
    public void deleteEmployee(int id){
        Predicate<? super Employee> predicate = employee -> employee.getId().equals(id);
        employeeList.removeIf(predicate);

    }


}
