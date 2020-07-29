package org.learn.hibernate.dao;

import org.learn.hibernate.domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {     //DAO stands for data access object

    public void insert(Employee employee);
    public void update(Employee employee);
    public Employee findByEmployeeId(Integer id);
    public List<Employee> findAll();
    public  void delete(Integer id) ;


}
