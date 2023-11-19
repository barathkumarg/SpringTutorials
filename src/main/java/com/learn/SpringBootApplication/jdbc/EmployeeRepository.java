package com.learn.SpringBootApplication.jdbc;
import com.learn.SpringBootApplication.EmployeeBean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;;
@Repository
public class EmployeeRepository {
   @Autowired
   private JdbcTemplate SpringJdbc;
   private String InsertString = """
                         insert into employee (id, name, location)
                         values (?,?,?)
                         """;
   private String DeleteString = """
                                 delete from employee where id = ?
                                 """;
   private String FindString = """
                               select * from employee where id = ?
                               """;
   //Insert Query to H2 DB
      public void insertQuery(Employee employee){
      SpringJdbc.update(InsertString,employee.getId(),employee.getName(),employee.getLocation());
      }

      //Delete Query by primary key
      public void deleteById(int id){
         SpringJdbc.update(DeleteString,id);
      }

      //Find the row with id of the employee and return in the Employee object
   public Employee findById(int id){
         return SpringJdbc.queryForObject(FindString, new BeanPropertyRowMapper<>(Employee.class),id);
   }

}
